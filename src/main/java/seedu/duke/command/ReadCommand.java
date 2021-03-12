package seedu.duke.command;

import seedu.duke.EmailManager;
import seedu.duke.Storage;
import seedu.duke.Ui;
import seedu.duke.email.Email;

import java.util.ArrayList;

public class ReadCommand extends Command {
    public ReadCommand(String s) {
        super(s);
    }

    @Override
    public void execute(EmailManager emails, Ui ui, Storage storage) {
        ArrayList<Email> listedEmails = EmailManager.getListedEmailsList();

        if (listedEmails == null) {
            String feedback = "You have to list emails first" + System.lineSeparator() +
                    "=> list emails" + System.lineSeparator();
            ui.printFeedback(feedback);
            return;
        }

        String indexStr = userInput.replaceAll("read", "").strip();
        int index = Integer.parseInt(indexStr);

        System.out.println(listedEmails.get(index - 1));
        System.out.println();

        System.out.println("Enter Command: ");
    }
}
