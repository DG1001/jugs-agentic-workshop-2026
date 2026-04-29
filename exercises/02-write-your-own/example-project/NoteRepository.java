import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NoteRepository {

    private static final Path STORE = Path.of("notes.db");

    public record Note(int id, String text, long createdAt) {
        public String title() {
            int newline = text.indexOf('\n');
            String firstLine = newline >= 0 ? text.substring(0, newline) : text;
            return firstLine.length() > 60 ? firstLine.substring(0, 57) + "..." : firstLine;
        }
    }

    public List<Note> findAll() throws IOException {
        return readAll();
    }

    public Note findById(int id) throws IOException {
        return readAll().stream()
                .filter(n -> n.id() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Note " + id + " not found"));
    }

    public List<Note> search(String query) throws IOException {
        var lower = query.toLowerCase();
        return readAll().stream()
                .filter(n -> n.text().toLowerCase().contains(lower))
                .collect(Collectors.toList());
    }

    public Note add(String text) throws IOException {
        var notes = readAll();
        int nextId = notes.stream().mapToInt(Note::id).max().orElse(0) + 1;
        var note = new Note(nextId, text, System.currentTimeMillis());
        notes.add(note);
        writeAll(notes);
        return note;
    }

    private List<Note> readAll() throws IOException {
        if (!Files.exists(STORE)) return new ArrayList<>();
        var notes = new ArrayList<Note>();
        for (var line : Files.readAllLines(STORE)) {
            if (line.isBlank()) continue;
            var parts = line.split("\u001f", 3);  // unit separator as field delim
            notes.add(new Note(
                    Integer.parseInt(parts[0]),
                    parts[2].replace("\u001e", "\n"),  // record separator -> newline
                    Long.parseLong(parts[1])
            ));
        }
        return notes;
    }

    private void writeAll(List<Note> notes) throws IOException {
        var lines = notes.stream()
                .map(n -> n.id() + "\u001f" + n.createdAt() + "\u001f"
                        + n.text().replace("\n", "\u001e"))
                .collect(Collectors.toList());
        Files.write(STORE, lines);
    }
}
