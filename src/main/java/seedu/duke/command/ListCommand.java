package seedu.duke.command;

import seedu.duke.email.EmailManager;
import seedu.duke.utilities.Parser;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;
import seedu.duke.email.Email;

import java.util.ArrayList;

public class ListCommand extends Command {
    public ListCommand(String s) {
        super(s);
    }

    @Override
    public void execute(EmailManager emails, Ui ui, Storage storage) {
        try {
            ArrayList<Email> emailTypeToPrint = Parser.getTypeToList(emails, userInput);
            emails.printEmailByType(emailTypeToPrint);
        } catch (AssertionError e1) {
            Ui.showInvalidListTypeMessage();
        }


    }
}
