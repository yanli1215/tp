package seedu.duke.command;

import seedu.duke.EmailManager;
import seedu.duke.Parser;
import seedu.duke.Storage;
import seedu.duke.Ui;
import seedu.duke.email.Archive;
import seedu.duke.email.Deleted;
import seedu.duke.email.Email;
import seedu.duke.exceptions.InvalidIndexException;

import java.util.ArrayList;

public class ArchiveCommand extends Command {
    public ArchiveCommand(String s) {
        super(s);
    }

    public void execute(EmailManager emails, Ui ui, Storage storage) {
        ArrayList<Email> listedEmails = EmailManager.getListedEmailsList();

        if (listedEmails == null) {
            String feedback = "You have to list emails first" + System.lineSeparator()
                    + "=> list emails" + System.lineSeparator();
            ui.printFeedback(feedback);
            return;
        }
        try {
            int index = Parser.extractIndex(userInput);
            if (index <= 0 || index > listedEmails.size()) {
                throw new InvalidIndexException();
            }
            Email archivedEmail = listedEmails.get(index - 1);
            emails.deleteEmail(archivedEmail);
            if (!(archivedEmail instanceof Archive)) {
                emails.addToDeleted(archivedEmail);
                System.out.println("Move this email to archive folder");
            } else {
                System.out.println("This email is already in archive folder");
            }
            //ui.showDeleteResult(deletedEmail, emails.getNumofEmails());
        } catch (InvalidIndexException e) {
            e.showErrorMessage("ARCHIVE");
        }

    }
}
