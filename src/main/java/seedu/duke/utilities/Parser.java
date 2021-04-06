package seedu.duke.utilities;

import seedu.duke.command.ArchiveCommand;
import seedu.duke.command.Command;
import seedu.duke.command.ComposeCommand;
import seedu.duke.command.DeleteCommand;
import seedu.duke.command.EditCommand;
import seedu.duke.command.ExitCommand;
import seedu.duke.command.FindCommand;
import seedu.duke.command.HelpCommand;
import seedu.duke.command.ListCommand;
import seedu.duke.command.NumberCommand;
import seedu.duke.command.ReadCommand;
import seedu.duke.command.ResetCommand;
import seedu.duke.command.SendCommand;
import seedu.duke.command.SortCommand;
import seedu.duke.command.TagCommand;
import seedu.duke.email.Email;
import seedu.duke.email.EmailManager;
import seedu.duke.exceptions.InvalidIndexException;

import java.util.ArrayList;
import java.util.Arrays;


public class Parser {
    private Command cmd;

    public Parser() {
        cmd = null;
    }

    public Command getCmd() {
        return cmd;
    }

    public void parse(String userInputString) {
        if (userInputString.toLowerCase().matches("^(list)[ ].*$")) {
            cmd = new ListCommand(userInputString);
        } else if (userInputString.equalsIgnoreCase("bye")) {
            cmd = new ExitCommand(userInputString);
        } else if (userInputString.equalsIgnoreCase("help")) {
            cmd = new HelpCommand(userInputString);
        } else if (userInputString.equalsIgnoreCase("reset")) {
            cmd = new ResetCommand(userInputString);
        } else if (userInputString.toLowerCase().matches("^(read)[ ].*$")) {
            cmd = new ReadCommand(userInputString);
        } else if (userInputString.toLowerCase().matches("^(delete)[ ].*$")) {
            cmd = new DeleteCommand(userInputString);
        } else if (userInputString.toLowerCase().matches("^(archive)[ ].*$")) {
            cmd = new ArchiveCommand(userInputString);
        } else if (userInputString.toLowerCase().matches("^(find)[ ].*$")) {
            cmd = new FindCommand(userInputString);
        } else if (userInputString.equalsIgnoreCase(("compose"))) {
            cmd = new ComposeCommand((userInputString));
        } else if (userInputString.toLowerCase().matches("^(send)[ ].*$")) {
            cmd = new SendCommand(userInputString);
        } else if (userInputString.toLowerCase().matches("^(tag)[ ].*$")) {
            cmd = new TagCommand(userInputString);
        } else if (userInputString.toLowerCase().matches("^(edit)[ ].*$")) {
            cmd = new EditCommand(userInputString);
        } else if (userInputString.toLowerCase().startsWith("number")) {
            cmd = new NumberCommand(userInputString);
        } else if (userInputString.toLowerCase().startsWith("sort")) {
            cmd = new SortCommand(userInputString);
        } else {
            throw new AssertionError(userInputString);
        }
    }

    public static boolean checkEmailValidity(String userInput) {

        String email = userInput.trim();
        if (!(email.endsWith("@outlook.com") || email.endsWith("@hotmail.com")
                || email.endsWith("@gmail.com") || email.endsWith("@yahoo.com"))) {
            return false;
        }
        if (email.startsWith("@")) {
            return false;
        }

        return true;
    }

    public static int extractIndex(String userInput) throws InvalidIndexException {
        try {
            String[] cmdArg = userInput.split(" ", 2);
            assert cmdArg.length > 1 : "cmdArg length <= 1";
            String args = cmdArg[1].trim();
            int indexShow = Integer.parseInt(args);
            return indexShow;
        } catch (NumberFormatException e) {
            throw new InvalidIndexException();
        }
    }

    public static String removeCommand(String userInput) {
        return userInput.split(" ", 2)[1];
    }

    public static int[] extractMultipleIndices(String userInput) throws InvalidIndexException {
        try {
            String[] indicesStr = userInput.split(" ");
            int[] indices = new int[indicesStr.length];
            for (int i = 0; i < indicesStr.length; i++) {
                indices[i] = Integer.parseInt(indicesStr[i].trim());
            }
            return indices;
        } catch (NumberFormatException e) {
            throw new InvalidIndexException();
        }
    }

    public static ArrayList<Email> getTypeToList(EmailManager emailManager, String userInput) {
        String[] cmdArg = userInput.split(" ", 2);
        String emailType = cmdArg[1].trim().toLowerCase();
        ArrayList<Email> emailsToPrint = null;
        emailManager.setListedType(emailType);
        switch (emailType) {
        case ("allemails"):
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
            throw new AssertionError(emailType);
        }
        return emailsToPrint;
    }

    /**
     * Converts a string containing multiple recipients to
     * a list of recipients.
     *
     * @param recipientsString String containing multiple recipients
     * @return list of recipients
     */
    public static ArrayList<String> parseRecipients(String recipientsString) {
        return new ArrayList<>(Arrays.asList(recipientsString.trim().split(";")));
    }
}
