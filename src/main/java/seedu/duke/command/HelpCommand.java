package seedu.duke.command;

import seedu.duke.email.EmailManager;
import seedu.duke.Utilities.Storage;
import seedu.duke.Utilities.Ui;

public class HelpCommand extends Command {

    public HelpCommand(String s) {
        super(s);
    }

    public void execute(EmailManager emails, Ui ui, Storage storage) {
        ui.printMenu();
    }

}
