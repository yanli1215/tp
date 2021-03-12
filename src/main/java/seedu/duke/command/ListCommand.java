package seedu.duke.command;

import seedu.duke.EmailManager;
import seedu.duke.Parser;
import seedu.duke.Storage;
import seedu.duke.Ui;

import java.util.ArrayList;

public class ListCommand extends Command {
    public ListCommand(String s) {
        super(s);
    }

    public void execute(EmailManager emails, Ui ui, Storage storage) {
        ArrayList emailTypeToPrint = Parser.getTypeToList(super.getUserInput());
        emails.printEmailByType(emailTypeToPrint);
    }
}
