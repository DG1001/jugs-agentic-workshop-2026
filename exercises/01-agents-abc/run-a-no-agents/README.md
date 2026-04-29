# Run A — Ohne AGENTS.md (Baseline)

Erste von drei Variantenläufen. Hier startet der Agent **blind**.

## Was hier liegt

```
tasklist.java       JBang-CLI mit list/add/remove/complete
tasks.txt           Beispiel-Daten (Format: id|title|done)
```

Keine AGENTS.md, keine Doku, keine Konventionen. Nur Code.

## Ausprobieren

```bash
jbang tasklist.java list
```

## Aufgabe

Gleicher Prompt wie in Run B und Run C:

> Erweitere das Tool um Prioritäten. Tasks sollen low/medium/high als
> Priorität haben. Der `list`-Befehl zeigt die Priorität mit an. Es
> soll möglich sein, die Liste nach Priorität sortiert anzuzeigen
> (höchste zuerst).

In dieses Verzeichnis wechseln und OpenCode starten:

```bash
cd run-a-no-agents
opencode
```

Beim ersten Start mit `/models` ein freies Modell wählen
(z.B. NVIDIA Nemotron Free oder Big Pickle Free), wenn ihr noch
keinen Provider konfiguriert habt. Wer einen Mistral-Key hat,
nutzt den.

Dann den Prompt eintippen und schauen, was passiert.

## Was beobachten

Notiert kurz:

- **Datenformat**: Wie speichert der Agent die Priorität? (enum? string?
  int? eigenes File?)
- **Default**: Was passiert mit existierenden Tasks ohne Priorität?
- **Sortierung**: Standardmäßig sortiert oder neuer Befehl?
- **Welche Files** hat der Agent gelesen? (im OpenCode-TUI in den
  Tool-Calls sichtbar)
- **Wie lange** hat es gedauert?

Das ist die Baseline. Danach gleicher Prompt mit Run B (schlechter
AGENTS.md) und Run C (guter AGENTS.md).
