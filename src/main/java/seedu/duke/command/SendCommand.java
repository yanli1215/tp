package seedu.duke.command;

import seedu.duke.EmailManager;
import seedu.duke.Parser;
import seedu.duke.Storage;
import seedu.duke.Ui;
import seedu.duke.email.Draft;
import seedu.duke.email.Email;
import seedu.duke.exceptions.InvalidIndexException;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SendCommand extends Command {
    public SendCommand(String s) {
        super(s);
    }

    public void execute(EmailManager emails, Ui ui, Storage storage) {
        ArrayList<Email> listedEmails = EmailManager.getListedEmailsList();
        if (listedEmails == null || !(listedEmails.get(0) instanceof Draft)) {
            String feedback = "You have to list DRAFT emails first" + System.lineSeparator()
                    + "=> list draft" + System.lineSeparator();
            ui.printFeedback(feedback);
            return;
        }

        ArrayList<Email> draftedEmails = EmailManager.getDraftEmails();
        if (draftedEmails.isEmpty()) {
            String feedback = "You have no emails to send.";
            ui.printFeedback(feedback);
            return;
        }

        try {
            int index = Parser.extractIndex(userInput);
            if (index <= 0 || index > draftedEmails.size()) {
                throw new InvalidIndexException();
            }
            Email draftEmail = draftedEmails.get(index - 1);
            draftEmail.setTime(String.valueOf(LocalDateTime.now()));
            emails.deleteEmail(draftEmail);
            emails.addToSent(draftEmail);
            ui.printEmailSent(draftEmail);
        } catch (InvalidIndexException e) {
            e.showErrorMessage("SENT");
        }
    }
}
