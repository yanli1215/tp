package seedu.duke.command;

import seedu.duke.EmailManager;
import seedu.duke.Storage;
import seedu.duke.Ui;
import seedu.duke.email.Email;

public class ArchiveCommand extends Command{
    public ArchiveCommand(Integer s) {
        super(s);
    }

    public void execute(EmailManager emails, Ui ui, Storage storage) {
        Email ArchivedEmail = emails.deleteEmail((Integer) getUserInput());
        emails.addToArchive(ArchivedEmail);
        System.out.println("Move this email to archive folder");
        //ui.showDeleteResult(deletedEmail, emails.getNumofEmails());
    }
}
