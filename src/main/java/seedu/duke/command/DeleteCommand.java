package seedu.duke.command;

import seedu.duke.EmailManager;
import seedu.duke.Storage;
import seedu.duke.Ui;
import seedu.duke.email.Email;
import seedu.duke.exceptions.InvalidIndexException;

public class DeleteCommand extends Command{

    public DeleteCommand(Integer s) {
        super(s);
    }

    public void execute(EmailManager emails, Ui ui, Storage storage) {
        Email deletedEmail = emails.deleteEmail((Integer) getUserInput());
        emails.addToDeleted(deletedEmail);
        System.out.println("Move this email to deleted folder");
            //ui.showDeleteResult(deletedEmail, emails.getNumofEmails());
    }

}
