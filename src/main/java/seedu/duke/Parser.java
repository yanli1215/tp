package seedu.duke;

import seedu.duke.command.*;
import seedu.duke.email.Archive;

import java.util.Locale;

public class Parser {
    private Command cmd;

    public Command getCmd() {
        return cmd;
    }

    public Parser() {
        cmd = null;
    }

    public void parse(String userInputString) {
        String[] cmdArg = userInputString.split(" ");
        String cmdType = cmdArg[0].trim().toLowerCase();
        //String args = cmdArg[1];

        switch (cmdType) {
        case "delete":
            cmd = prepareDelete(cmdArg);
            break;
        case "archive":
            cmd = prepareArchive(cmdArg);
            break;
        case "list":
            cmd = new ListCommand(userInputString);
            break;
        case "exit":
            cmd = new ExitCommand();
            break;
        default:
            cmd = null;
        }

    }

    public DeleteCommand prepareDelete(String[] cmdArg) {
        String args = cmdArg[1].trim();
        int IndexShow = Integer.parseInt(args);
        return new DeleteCommand(IndexShow);
    }
    public ArchiveCommand prepareArchive(String[] cmdArg) {
        String args = cmdArg[1].trim();
        int IndexShow = Integer.parseInt(args);
        return new ArchiveCommand(IndexShow);
    }
}
