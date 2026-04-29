import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class NoteRenderer {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").withZone(ZoneId.systemDefault());

    public static String renderList(List<NoteRepository.Note> notes) {
        if (notes.isEmpty()) return "No notes.";
        var sb = new StringBuilder();
        for (var note : notes) {
            sb.append(String.format("%4d  %s%n", note.id(), note.title()));
        }
        return sb.toString();
    }

    public static String renderDetail(NoteRepository.Note note) {
        var when = FORMATTER.format(Instant.ofEpochMilli(note.createdAt()));
        return String.format("Note #%d  (%s)%n%n%s", note.id(), when, note.text());
    }
}
