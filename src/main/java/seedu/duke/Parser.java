package seedu.duke;

public class Parser {
    public String[] parseCommand(String input) {
        String[] splitted = input.split(" ", 2);
        return (splitted.length == 2) ?  splitted : (new String[]{splitted[0], ""});
    }
}
