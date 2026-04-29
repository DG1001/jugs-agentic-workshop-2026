///usr/bin/env jbang "$0" "$@" ; exit $?
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class tasklist {

    static final Path STORE = Path.of("tasks.txt");

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            printHelp();
            return;
        }
        switch (args[0]) {
            case "list"     -> list();
            case "add"      -> add(String.join(" ", Arrays.copyOfRange(args, 1, args.length)));
            case "remove"   -> remove(Integer.parseInt(args[1]));
            case "complete" -> complete(Integer.parseInt(args[1]));
            default         -> printHelp();
        }
    }

    static void list() throws IOException {
        var lines = readAll();
        if (lines.isEmpty()) {
            System.out.println("No tasks yet.");
            return;
        }
        for (var line : lines) {
            var parts = line.split("\\|", 3);
            var marker = parts[2].equals("true") ? "[x]" : "[ ]";
            System.out.println(marker + " " + parts[0] + ": " + parts[1]);
        }
    }

    static void add(String title) throws IOException {
        var lines = readAll();
        int nextId = lines.stream()
                .mapToInt(l -> Integer.parseInt(l.split("\\|")[0]))
                .max()
                .orElse(0) + 1;
        lines.add(nextId + "|" + title + "|false");
        Files.write(STORE, lines);
        System.out.println("Added task " + nextId + ": " + title);
    }

    static void remove(int id) throws IOException {
        var lines = readAll();
        var kept = lines.stream()
                .filter(l -> !l.startsWith(id + "|"))
                .collect(Collectors.toList());
        Files.write(STORE, kept);
        System.out.println("Removed task " + id);
    }

    static void complete(int id) throws IOException {
        var lines = readAll();
        var updated = lines.stream()
                .map(l -> {
                    var parts = l.split("\\|", 3);
                    if (parts[0].equals(String.valueOf(id))) {
                        return parts[0] + "|" + parts[1] + "|true";
                    }
                    return l;
                })
                .collect(Collectors.toList());
        Files.write(STORE, updated);
        System.out.println("Completed task " + id);
    }

    static List<String> readAll() throws IOException {
        if (!Files.exists(STORE)) return new ArrayList<>();
        return new ArrayList<>(Files.readAllLines(STORE));
    }

    static void printHelp() {
        System.out.println("Usage: tasklist <command> [args]");
        System.out.println("Commands:");
        System.out.println("  list             Show all tasks");
        System.out.println("  add <title>      Add a new task");
        System.out.println("  remove <id>      Remove task by id");
        System.out.println("  complete <id>    Mark task as done");
    }
}
