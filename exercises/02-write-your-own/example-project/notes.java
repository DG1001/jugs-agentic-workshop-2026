///usr/bin/env jbang "$0" "$@" ; exit $?
//SOURCES NoteRepository.java NoteRenderer.java

import java.io.IOException;
import java.util.Arrays;

public class notes {

    public static void main(String[] args) throws IOException {
        var repo = new NoteRepository();

        if (args.length == 0) {
            printHelp();
            return;
        }
        switch (args[0]) {
            case "list" -> {
                var notes = repo.findAll();
                System.out.println(NoteRenderer.renderList(notes));
            }
            case "add" -> {
                var text = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
                var note = repo.add(text);
                System.out.println("Added note " + note.id());
            }
            case "show" -> {
                var note = repo.findById(Integer.parseInt(args[1]));
                System.out.println(NoteRenderer.renderDetail(note));
            }
            case "search" -> {
                var query = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
                var hits = repo.search(query);
                System.out.println(NoteRenderer.renderList(hits));
            }
            default -> printHelp();
        }
    }

    static void printHelp() {
        System.out.println("Usage: notes <command> [args]");
        System.out.println("  list                  List all notes (titles only)");
        System.out.println("  add <text>            Add a new note");
        System.out.println("  show <id>             Show full note");
        System.out.println("  search <query>        Search notes by substring");
    }
}
