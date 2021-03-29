package seedu.duke.command;

import seedu.duke.email.EmailManager;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;

public class HelpCommand extends Command {

    public HelpCommand(String s) {
        super(s);
    }

    public void execute(EmailManager emails, Ui ui, Storage storage) {
        ui.printMenu();
    }

}
