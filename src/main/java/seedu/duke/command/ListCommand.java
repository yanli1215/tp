package seedu.duke.command;

import seedu.duke.EmailManager;
import seedu.duke.Storage;
import seedu.duke.Ui;
import seedu.duke.email.Email;

public class ListCommand extends Command {
    public ListCommand(String s) {
        super(s);
    }

    public void execute(EmailManager emails, Ui ui, Storage storage) {
        emails.listAllEmails();
    }
}
