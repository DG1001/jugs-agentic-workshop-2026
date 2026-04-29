# Übung 2 — Schreib deine eigene AGENTS.md (25 Min)

Aus den Folien: maximal **100 Zeilen**, **nichts Generisches**.

## Ablauf (25 Min)

1. **15 Min Schreiben** — siehe Pflicht-Bestandteile unten
2. **5 Min Testen** — eine reale Aufgabe an euren Agent geben, schauen
   ob die AGENTS.md hilft
3. **5 Min Peer-Review** — mit dem Sitznachbarn tauschen, kurz Feedback
   geben

## Pflicht-Bestandteile (aus den Folien)

- [ ] **1 Decision-Table** für eine echte Wahl im Projekt
- [ ] **1 nummerierter Workflow** für einen wiederkehrenden Task
- [ ] **3–5 Don't/Do-Paare** (statt einer Verbots-Liste)
- [ ] **2–3 Code-Snippets** (3–10 Zeilen) aus dem realen Code

## Was ihr weglasst (auch aus den Folien)

- ✕ Lange Architektur-Erklärungen mit „warum"
- ✕ Mehr als 10 Don'ts ohne passende Dos
- ✕ Allgemeine Coding-Best-Practices ohne Projekt-Bezug
- ✕ Verweise auf Doks, die niemand pflegt

## Auf welchem Code arbeiten?

**Bevorzugt: euer eigenes Projekt.** Wenn ihr eines mitgebracht habt,
nehmt das. Eine AGENTS.md ist nur dann ehrlich gut, wenn sie aus
echten Schmerzpunkten geboren wird.

**Alternativ: das Beispiel-Projekt** im Unterordner `example-project/`.
Das ist ein kleines Multi-File Notes-CLI mit drei Files
(`notes.java`, `NoteRepository.java`, `NoteRenderer.java`). Hat
genug Substanz für sinnvolle Konventionen — z.B.:

- **Decision**: Wo gehören neue Felder hin (Note-Record, Repository,
  Renderer)?
- **Workflow**: Wie kommt ein neuer Befehl rein?
- **Don't/Do**: Speicherformat (das ASCII-Unit-Separator-Format ist
  bewusst gewählt — Agent soll nicht „mal eben" auf JSON umstellen)

> 💡 **Inspiration**: Im Repo-Root liegt `WORKSPACE-AGENTS.md` —
> die echte AGENTS.md, die XaresAICoder standardmäßig in jeden
> Workspace legt (Bind 0.0.0.0, URL-Patterns, etc.). Schaut sie
> euch an: ist sie nach den 6 Mustern aus den Folien gebaut?
> Was würdet ihr verbessern?

## Template

Wer einen Startpunkt braucht, kopiert sich das Skelett:

```bash
cp AGENTS.template.md AGENTS.md
# dann editieren
```

Liegt im selben Verzeichnis. Aber: das Template ist nur ein Gerüst,
nicht ein Lückentext. Schreibt eure eigenen Regeln rein.

## Test-Aufgabe (für Schritt 2)

Wenn ihr beim Beispiel-Projekt seid und eine konkrete Test-Aufgabe
braucht:

> Füge dem Notes-Tool einen `delete <id>`-Befehl hinzu.

Im OpenCode-TUI im `example-project/`-Verzeichnis testen. Bleibt
der Agent in der Spur eurer AGENTS.md? Macht er das Speicherformat
kaputt? Aktualisiert er den Help-Text?

## Peer-Review (für Schritt 3)

Tauscht mit dem Sitznachbarn die AGENTS.md. Drei Fragen:

1. **Würde ich als Agent verstehen, was hier gemeint ist?**
2. **Welche Don't/Do-Paare sind unkonkret und brauchen ein Beispiel?**
3. **Was fehlt — und was ist überflüssig?**

Frederik moderiert hinterher kurz: was war das stärkste Pattern, was
das überraschendste Weggelassene.
