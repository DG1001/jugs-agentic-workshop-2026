# tasklist — AGENTS.md

Single-file JBang-CLI für Aufgaben. Persistenz: `tasks.txt`,
Format `id|title|done`. Java 21, keine externen Deps.

## Decision Table — Wie speichern wir neue Felder?

Wenn ein neues Task-Attribut hinzukommt (Priorität, Kategorie,
Fälligkeitsdatum, …), dann gilt:

| Frage | Antwort |
|---|---|
| Format-Erweiterung? | **Neue Spalte** in `tasks.txt`, hinten anhängen |
| Trennzeichen? | `\|` — bleibt gleich, nicht ändern |
| Datentyp im Code? | **Java enum** wenn endliche Wertemenge, sonst `String` |
| Default-Wert? | Pflicht, vom Code gesetzt — *nicht* beim Schreiben fragen |
| Migration alter Zeilen? | Beim Lesen: fehlende Spalte → Default verwenden |
| Sortier-Reihenfolge? | Wenn enum: Reihenfolge der Deklaration ist die Sortierreihenfolge |

## Workflow — Neuen CLI-Befehl hinzufügen

1. Neuen `case` im `switch` von `main()` hinzufügen.
2. Korrespondierende `static`-Methode am Ende der Datei.
3. `printHelp()` um die neue Zeile ergänzen.
4. Beim Lesen über `readAll()` gehen, beim Schreiben über
   `Files.write(STORE, ...)`.
5. Manuell testen: `jbang tasklist.java <neuer-befehl> ...`.

## Workflow — Neues Feld am Task hinzufügen

1. Neue Spalte in `tasks.txt` ergänzen (siehe Decision Table).
2. Beim Lesen: `split("\\|", -1)` damit leere Spalten erhalten bleiben,
   fehlende Werte mit Default ersetzen.
3. Beim Schreiben: alle Spalten in stabiler Reihenfolge zusammenfügen.
4. `list()` so anpassen, dass die neue Info sichtbar wird.
5. Bestehende `tasks.txt` muss **ohne Migration weiter funktionieren**
   — der Lese-Code kümmert sich automatisch.

## Don't / Do

| ✕ Don't | ✓ Do |
|---|---|
| Eigene `Task`-Klasse einführen | In `String[]`-Arrays bleiben, wie der bestehende Code |
| Neue Datei `Priority.java` | Als nested `enum` *in* `tasklist` |
| Externe Library für CLI-Parsing | Bestehender `switch (args[0])` reicht |
| Tests in eigenem Modul | Manuell testen — bewusst kein Test-Framework |
| `printHelp()` weglassen | Help-Text *immer* aktualisieren wenn ein Befehl dazukommt |

## Beispiel — wie ein neues Feld aussehen würde

```java
// In tasks.txt:
//   1|Task A|false|HIGH
//   2|Task B|true|LOW

enum Priority { HIGH, MEDIUM, LOW }

static Priority parsePriority(String[] parts) {
    return parts.length >= 4 ? Priority.valueOf(parts[3]) : Priority.MEDIUM;
}
```

(3 Zeilen Default-Behandlung — das ist die Migration.)
