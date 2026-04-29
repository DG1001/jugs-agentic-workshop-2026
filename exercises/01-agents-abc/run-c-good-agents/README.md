# Run C — „Gute" AGENTS.md

Identischer Code wie Run A und Run B. Aber: Hier liegt eine knappe
`AGENTS.md` (~80 Zeilen), die genau die Muster aus den Folien hat:

- **1 Decision-Table**: Wie speichern wir neue Felder?
- **2 Workflows**: Neuen Befehl, neues Feld
- **5 Don't/Do-Paare** mit konkreter Alternative
- **1 Code-Snippet** aus dem realen Code (3 Zeilen Default-Handling)

Keine Architektur-Doku, keine Compliance, keine Reference-Files.
Nur das, was der Agent für *diese* Aufgabe wirklich braucht.

## Aufgabe

**Exakt derselbe Prompt wie in Run A und Run B:**

> Erweitere das Tool um Prioritäten. Tasks sollen low/medium/high als
> Priorität haben. Der `list`-Befehl zeigt die Priorität mit an. Es
> soll möglich sein, die Liste nach Priorität sortiert anzuzeigen
> (höchste zuerst).

In dieses Verzeichnis wechseln, OpenCode starten, Prompt eintippen:

```bash
cd run-c-good-agents
opencode
```

## Was beobachten

Die Folien sagen voraus: **+25 % Best-Practice-Score**. Konkret hier:

- Wählt der Agent jetzt direkt `enum` (wie die Decision-Table sagt),
  ohne darüber zu philosophieren?
- Hängt er die Priorität als 4. Spalte an, nicht als neues File?
- Migriert er existierende Zeilen sauber (Default `MEDIUM` für die
  alten Tasks)?
- Aktualisiert er `printHelp()`?
- Ist der Code danach kürzer / klarer als in Run A oder Run B?
- Wie viele Tool-Calls? Vermutlich deutlich weniger als in Run B.

## Vergleich am Tisch

Legt euch die drei Outputs nebeneinander (Run A / B / C) und schaut:

- Welche Variante hat den **saubersten Code**?
- Welche hat den **kürzesten Diff**?
- In welcher hat der Agent am wenigsten **gegrübelt**?
- Wo war Code-Migration sauber, wo gar nicht?

Frederik zeigt gleich am Beamer: was die Token-Differenz war (gemessen
in den vorab gemachten Captures auf einer ähnlichen Codebasis).
