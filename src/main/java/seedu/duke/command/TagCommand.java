package seedu.duke.command;

import seedu.duke.email.EmailManager;
import seedu.duke.Utilities.Parser;
import seedu.duke.Utilities.Storage;
import seedu.duke.Utilities.Ui;
import seedu.duke.email.Email;
import seedu.duke.exceptions.InvalidIndexException;

import java.util.ArrayList;

public class TagCommand extends Command {

    public TagCommand(String s) {
        super(s);
    }

    @Override
    public void execute(EmailManager tasks, Ui ui, Storage storage) {
        ArrayList<Email> listedEmails = EmailManager.getListedEmailsList();

        if (listedEmails == null) {
            String feedback = "You have to list emails first" + System.lineSeparator()
                    + "=> list emails" + System.lineSeparator();
            ui.printFeedback(feedback);
            return;
        }

        Email email;

        try {
            int index = Parser.extractIndex(userInput);
            if (index <= 0 || index > listedEmails.size()) {
                throw new InvalidIndexException();
            }
            email = listedEmails.get(index - 1);
        } catch (InvalidIndexException e) {
            e.showErrorMessage("TAG");
            return;
        }

        String feedback = "You have selected this email:" + System.lineSeparator()
                + email.getShortDescription();

        ui.printFeedback(feedback);
        String input = ui.printTag();

        try {
            String args = Parser.removeCommand(userInput);
            int[] indices = Parser.extractMultipleIndices(input);
            ArrayList<String> tags = email.setTags(indices);
            feedback = "You have successfully set the following tags " + tags.toString();
            ui.printFeedback(feedback);
        } catch (InvalidIndexException e) {
            e.showErrorMessage("TAG");
        }
    }
}