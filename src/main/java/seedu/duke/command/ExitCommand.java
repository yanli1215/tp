package seedu.duke.command;

import seedu.duke.EmailManager;
import seedu.duke.Storage;
import seedu.duke.Ui;
import seedu.duke.email.Email;

public class ExitCommand extends Command {
    public ExitCommand(String s) {
        super(s);
    }

    public void execute(EmailManager tasks, Ui ui, Storage storage) {
        System.exit(0);
    }
}
