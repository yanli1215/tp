package seedu.duke.command;

import seedu.duke.EmailManager;
import seedu.duke.Parser;
import seedu.duke.Storage;
import seedu.duke.Ui;
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
        } catch (NullPointerException e1) {
            Ui.showInvalidListTypeMessage();
        }


    }
}
