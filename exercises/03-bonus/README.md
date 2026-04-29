# Bonus-Übungen — wenn ihr Zeit habt

Wer mit Übung 1 und 2 fertig ist, kann hier weitermachen.

## Bonus A — Modul-AGENTS.md

Aus den Folien (Take-aways): „Modul-AGENTS.md > Repo-Root-Mega-Datei."

Probiert das im `02-write-your-own/example-project/` aus:

- Eine `AGENTS.md` am Root mit Top-Level-Konventionen
- Eine `AGENTS.md` *im* `example-project/`-Ordner mit Modul-spezifischen
  Regeln (z.B. „NoteRepository ist die einzige File-I/O-Stelle, kein
  anderes File schreibt nach `notes.db`")

Schaut, ob euer Tool beide einliest. Claude Code liest beide Ebenen,
Aider und Gemini sind unterschiedlich aufmerksam. Das selbst zu
beobachten ist die Übung.

## Bonus B — Reverse-Engineering bestehender AGENTS.md

Holt euch eine echte AGENTS.md und wendet die Folien-Cheatsheet
darauf an.

**Naheliegendes Beispiel**: `WORKSPACE-AGENTS.md` im Repo-Root —
die echte AGENTS.md, die XaresAICoder in jeden Workspace legt.
Liegt direkt im Repo, schon klar, was sie regelt (Bind 0.0.0.0,
URLs, Git, Troubleshooting).

**Weitere Repos zum Stöbern**:

```bash
git clone https://github.com/sst/opencode.git
cat opencode/AGENTS.md  # oder CLAUDE.md, je nach Repo
```

Wendet die Folien-Cheatsheet an:

- Wie viele Zeilen?
- Decision-Tables vorhanden?
- Wie viele Don't/Do-Paare?
- Modulares Setup oder Mega-Datei?

Was ist gut, was würdet ihr anders machen?

## Bonus C — Anti-Pattern-Test mit dem eigenen Projekt

Nehmt euer eigenes Projekt aus Übung 2 und macht einen A/B-Vergleich:

- Variante 1: Eure schöne kompakte AGENTS.md
- Variante 2: Plus 30 künstliche Don'ts ohne Dos (Lorem-Ipsum-Style)

Gleicher Prompt in beiden Varianten. Sieht man die Overexploration
auch bei einer „grundsätzlich guten" AGENTS.md, wenn man sie
verschmutzt? (Spoiler: ja — und ziemlich schnell.)

## Bonus D — Inspiration für die nächste Iteration

Aus den Take-aways: „Was nicht in AGENTS.md steht oder von dort
verlinkt ist, sieht der Agent praktisch nicht."

Schaut auf euer eigenes Projekt: Welche **drei** Konventionen, die ihr
heute „im Kopf" habt, gehören in eine AGENTS.md? Schreibt sie auf.
Das ist eure Hausaufgabe für die nächste Woche.
