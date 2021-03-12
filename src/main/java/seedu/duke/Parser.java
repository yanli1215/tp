package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.command.ExitCommand;
import seedu.duke.command.ListCommand;

public class Parser {
    private Command cmd;

    public Command getCmd() {
        return cmd;
    }

    public Parser() {
        cmd = null;
    }

    public void parse(String userInputString) {
        if (userInputString.equalsIgnoreCase("LIST")) {
            cmd =  new ListCommand(userInputString);
        } else if (userInputString.equalsIgnoreCase("exit")) {
            cmd =  new ExitCommand(userInputString);
        } else {
            cmd = null;
        }

    }
}
