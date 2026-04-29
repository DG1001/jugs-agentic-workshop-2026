# Agentic Coding Workshop — JUG Stuttgart

Hands-on Workshop-Material zum **Agentic Coding** Workshop am
**30. April 2026** an der Uni Stuttgart, organisiert von der
[Java User Group Stuttgart](https://www.jugs.org/).

Das Material besteht aus zwei Übungen rund um `AGENTS.md` und
Coding Agents. Wir arbeiten primär mit **OpenCode** im kostenlosen
Modus (kein Login, eingebaute Free-Modelle). Wer einen eigenen
**Mistral-API-Key** mitbringt, kann den optional nutzen.

> **Format**: 30. April 2026 · 10:00–17:00 Uhr · Uni Stuttgart, Raum 1.311
> **Anmeldung**: agentic@jugs.org (Subject: Coding Workshop Registration)

---

## Was hier liegt

```
exercises/
├── 01-agents-abc/            Übung 1: A/B/C-Test mit AGENTS.md (20 Min)
│   ├── run-a-no-agents/      Variante A: ohne AGENTS.md (Baseline)
│   ├── run-b-bad-agents/     Variante B: schlechte AGENTS.md
│   └── run-c-good-agents/    Variante C: gute AGENTS.md
│
├── 02-write-your-own/        Übung 2: Schreib deine eigene (25 Min)
│   ├── example-project/      Multi-File Notes-CLI als Übungsstoff
│   └── AGENTS.template.md    Skelett zum Loslegen
│
└── 03-bonus/                 Bonus-Aufgaben für daheim

WORKSPACE-AGENTS.md           Referenz-AGENTS.md für XaresAICoder-Workspaces
                              (Bind 0.0.0.0 etc.) — nicht als AGENTS.md, damit
                              Übung 1 sauber bleibt
```

Jeder Übungsordner hat eine eigene `README.md` mit Aufgabe, Prompt
und Beobachtungs-Hinweisen.

---

## Setup

### Variante A — Workshop-Tag mit XaresAICoder

Wenn du am Workshop teilnimmst, bekommst du beim Eintreffen einen
fertigen Browser-Workspace zugewiesen. Dieser Inhalt liegt schon drin.
**Du musst nichts installieren.**

OpenCode ist vorinstalliert und läuft im **Free-Modus ohne Login** —
keine API-Keys nötig. Wer einen eigenen Mistral-Codestral-API-Key
mitbringt, kann den per `/connect` einbinden.

### Variante B — Lokales Setup

Wenn du lieber lokal arbeitest (am Workshop-Tag oder daheim), brauchst
du:

- **Java 21+** (für die JBang-Beispiele)
  ```bash
  # macOS
  brew install openjdk@21
  # Linux
  sudo apt-get install openjdk-21-jdk
  # oder via SDKMAN
  sdk install java 21-tem
  ```

- **JBang** (führt single-file Java direkt aus)
  ```bash
  curl -Ls https://sh.jbang.dev | bash -s - app setup
  ```

- **OpenCode** als Coding Agent
  ```bash
  # Installation
  curl -fsSL https://opencode.ai/install | bash

  # Im Projekt-Verzeichnis starten — kein Login nötig
  opencode
  ```

  Im OpenCode-TUI: `/models` öffnet die Modell-Auswahl. Ohne
  konfigurierten API-Key bekommst du Zugriff auf die kostenlosen
  Modelle (z.B. NVIDIA Nemotron Free, Big Pickle Free). Die reichen
  für alle Workshop-Übungen aus.

- **Optional: Mistral-API-Key** für mehr Power
  Wer eine konsistentere Erfahrung will: einen kostenlosen
  Codestral-API-Key holen unter
  [console.mistral.ai](https://console.mistral.ai/codestral) →
  „Generate API Key". Dann in OpenCode `/connect` → Mistral wählen
  → Key einfügen.

- **Repo klonen**
  ```bash
  git clone https://github.com/<owner>/jugs-agentic-workshop-2026.git
  cd jugs-agentic-workshop-2026
  ```

Test, dass alles läuft:

```bash
cd exercises/01-agents-abc/run-a-no-agents
jbang tasklist.java list
# Erwartet: 4 Tasks aus tasks.txt
```

---

## Wenn du eigene Apps in einem XaresAICoder-Workspace baust

(Relevant für Übung 2, Bonus, oder generell wenn du den Workspace
über den Workshop hinaus nutzt.)

XaresAICoder läuft im Container — Apps müssen auf `0.0.0.0` binden,
nicht auf `localhost`, sonst sind sie über den Browser nicht
erreichbar. Plus es gibt ein paar Konventionen für URLs, Git, etc.

Im Standard-Workspace liegt dafür schon eine `AGENTS.md` am Root.
**In diesem Repo ist sie absichtlich als `WORKSPACE-AGENTS.md`
abgelegt** — damit Übung 1 (A/B/C-Test) eine saubere Baseline ohne
globale AGENTS.md hat.

Wenn du die globale AGENTS.md im Workspace haben willst:

```bash
cp WORKSPACE-AGENTS.md AGENTS.md
```

Damit liest OpenCode (und andere Coding Agents) die Regeln
automatisch mit.

> ⚠️ **Wichtig**: Wenn du im Repo arbeitest und gleichzeitig Übung 1
> machen willst, lass `AGENTS.md` am Root *weg* (steht in `.gitignore`).
> Sonst verfälscht sie den A/B/C-Vergleich.

---

## Tagesablauf (30.04.2026)

| Zeit | Inhalt | Lead |
|---|---|---|
| 10:00 | Begrüßung & Überblick | Frederik & Artur |
| 10:10 | Setup, Tool-Test | Artur |
| 11:00 | AGENTS.md — Mini-Input + Übung 1 (A/B/C) | Frederik |
| 12:00 | Mittagspause | — |
| 12:45 | Muster für gute AGENTS.md + Übung 2 | Frederik |
| 13:30 | Deep Dive: Was passiert unter der Haube? | Frederik |
| 14:15 | Pause | — |
| 14:30 | Spring AI RPG | Arnaud Jean (AWS) |
| 17:00 | Ende | — |

---

## Hintergrund

Das Material orientiert sich an Erkenntnissen aus der
[Augment-Code-AGENTS.md-Studie](https://www.augmentcode.com/blog/how-to-write-good-agents-dot-md-files)
(Zhenylenko, April 2026). Konkret:

- Eine **gute** AGENTS.md = +25 % Best-Practice-Score
- Eine **schlechte** AGENTS.md = −30 % Vollständigkeit (schlechter
  als gar keine)

Übung 1 macht beide Effekte am eigenen Code sichtbar.

Der Deep-Dive-Teil zeigt am `mitmproxy`-API-Logger des
[XaresAICoder](https://github.com/DG1001/XaresAICoder), was zwischen
Coding Agent und LLM tatsächlich an Tokens fließt — und warum
manche Tools 10× geschwätziger sind als andere.

## Quellen & Dank

- **Augment Code**: AGENTS.md-Patterns aus AuggieBench-Studie
- **iteratec GmbH** (David Schowalter): Vortrag *„Agentic Coding im
  Team"* am 29.04. (Vortragsabend) — siehe
  [JUG-Webseite](https://www.jugs.org/)
- **AWS** (Arnaud Jean): Spring AI RPG Workshop am 30.04. Nachmittag
- **Java User Group Stuttgart**: Organisation und Räumlichkeiten

## Lizenz

MIT — siehe [LICENSE](LICENSE).

Übungs-Code und Beispiele dürfen in eigenen Workshops, Vorträgen und
Materialien verwendet werden. Hinweis auf den Ursprung wäre nett.
