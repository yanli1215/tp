package seedu.duke.command;

import seedu.duke.email.EmailManager;
import seedu.duke.Utilities.Storage;
import seedu.duke.Utilities.Ui;

public class ExitCommand extends Command {
    public ExitCommand(String s) {
        super(s);
    }

    public void execute(EmailManager tasks, Ui ui, Storage storage) {
        System.exit(0);
    }
}
