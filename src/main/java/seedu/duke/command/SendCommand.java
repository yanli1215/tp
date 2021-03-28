package seedu.duke.command;

import seedu.duke.email.EmailManager;
import seedu.duke.Utilities.Parser;
import seedu.duke.Utilities.Storage;
import seedu.duke.Utilities.Ui;
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

        Email[] sendEmailList = null;

        try {
            String args = Parser.removeCommand(userInput);
            int[] indices = Parser.extractMultipleIndices(args);
            sendEmailList = new Email[indices.length];
            for (int i = 0; i < indices.length; i++) {
                if (indices[i] <= 0 || indices[i] > draftedEmails.size()) {
                    throw new InvalidIndexException();
                }
                sendEmailList[i] = draftedEmails.get(indices[i] - 1);
            }
        } catch (InvalidIndexException e) {
            e.showErrorMessage("SENT");
        }

        assert sendEmailList != null;

        for (Email draftEmail : sendEmailList) {
            draftEmail.setTime(String.valueOf(LocalDateTime.now()));
            emails.deleteEmail(draftEmail);
            emails.addToSent(draftEmail);
            ui.printEmailSent(draftEmail);
        }
    }
}
