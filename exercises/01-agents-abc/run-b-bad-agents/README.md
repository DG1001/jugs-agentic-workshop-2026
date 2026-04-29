# Run B — „Schlechte" AGENTS.md

Identischer Code wie Run A. Aber: Hier liegt eine `AGENTS.md`, die
exakt die Anti-Pattern aus den Folien zeigt:

- Lange Architektur-Übersicht ohne Bezug zur tatsächlichen Codebase
- Service-Topologie für „geplante" Services, die nicht existieren
- Compliance-Sektion (GDPR, HIPAA, SOX, ISO 27001 — für ein 80-Zeilen
  CLI-Tool)
- 35 nummerierte Don'ts, kein einziges Do
- Verweise auf 10 Reference-Files, die alle „(planned)" sind

Das ist absichtlich übertrieben. Die Wirkung soll sichtbar werden.

## Aufgabe

**Exakt derselbe Prompt wie in Run A:**

> Erweitere das Tool um Prioritäten. Tasks sollen low/medium/high als
> Priorität haben. Der `list`-Befehl zeigt die Priorität mit an. Es
> soll möglich sein, die Liste nach Priorität sortiert anzuzeigen
> (höchste zuerst).

In dieses Verzeichnis wechseln, OpenCode starten, Prompt eintippen:

```bash
cd run-b-bad-agents
opencode
```

## Was beobachten

Die Folien sagen voraus: **Overexploration**. Konkret:

- Liest der Agent jetzt die `AGENTS.md` zuerst (hoffentlich), und
  *wie lange* hängt er darin?
- Sucht er nach den genannten Reference-Files (`docs/architecture/...`),
  obwohl es sie nicht gibt?
- Versucht er, Hexagonal Architecture umzusetzen für einen Befehl, der
  fünf Zeilen Code braucht?
- Schreibt er Tests, weil eine Don't-Regel das fordert?
- Wird der Code dadurch komplexer als in Run A?
- Wie viele Tool-Calls (read/grep) zusätzlich?
- Gefühlte Dauer im Vergleich zu Run A?

Notiert das. Frederik wird es gleich am Beamer mit den Proxy-Captures
gegenüberstellen.
