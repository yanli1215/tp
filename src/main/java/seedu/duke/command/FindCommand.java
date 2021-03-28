package seedu.duke.command;

import seedu.duke.email.EmailManager;
import seedu.duke.Utilities.Parser;
import seedu.duke.Utilities.Storage;
import seedu.duke.Utilities.Ui;
import seedu.duke.email.Email;

import java.util.ArrayList;

public class FindCommand extends Command{
    public FindCommand(String s) {
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

        String keyword = Parser.extractKeyword(userInput);
        ArrayList<Email> findEmails = emails.findByString(listedEmails, keyword);
        EmailManager.printEmailByType(findEmails);

    }
}
