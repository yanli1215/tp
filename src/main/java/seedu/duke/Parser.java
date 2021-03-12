package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.command.ExitCommand;
import seedu.duke.command.HelpCommand;
import seedu.duke.command.ListCommand;
import seedu.duke.command.ReadCommand;
import seedu.duke.email.Email;

import java.util.ArrayList;

public class Parser {
    private Command cmd;
    private static EmailManager emailManager;

    public Parser() {
        cmd = null;
    }

    public static ArrayList<Email> getTypeToList(String userInput) {
        String emailType = userInput.replaceAll("list", "").strip();
        ArrayList emailsToPrint = null;
        switch (emailType) {
        case ("emails"):
            emailsToPrint = emailManager.getAllEmails();
            break;
        case ("archive"):
            emailsToPrint = emailManager.getArchivedEmails();
            break;
        case ("deleted"):
            emailsToPrint = emailManager.getDeletedEmails();
            break;
        case ("draft"):
            emailsToPrint = emailManager.getDraftEmails();
            break;
        case ("inbox"):
            emailsToPrint = emailManager.getInboxEmails();
            break;
        case ("junk"):
            emailsToPrint = emailManager.getJunkEmails();
            break;
        case ("sent"):
            emailsToPrint = emailManager.getSentEmails();
            break;
        default:
        }
        return emailsToPrint;
    }

    public Command getCmd() {
        return cmd;
    }

    public void parse(String userInputString) {
        if (userInputString.toLowerCase().contains("list")) {
            cmd = new ListCommand(userInputString);
        } else if (userInputString.equalsIgnoreCase("BYE")) {
            cmd = new ExitCommand(userInputString);
        } else if (userInputString.equalsIgnoreCase("HELP")) {
            cmd = new HelpCommand(userInputString);
        } else if (userInputString.toLowerCase().contains("read")) {
            cmd = new ReadCommand(userInputString);
        } else {
            cmd = null;
        }
    }
}
