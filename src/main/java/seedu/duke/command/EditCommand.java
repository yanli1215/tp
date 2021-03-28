package seedu.duke.command;

import com.sun.jdi.InvalidTypeException;
import seedu.duke.email.EmailManager;
import seedu.duke.utilities.Parser;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;
import seedu.duke.email.Draft;
import seedu.duke.email.Email;
import seedu.duke.exceptions.InvalidIndexException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class EditCommand extends Command {
    public EditCommand(String s) {
        super(s);
    }

    @Override
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
            String feedback = "You have no emails to edit.";
            ui.printFeedback(feedback);
            return;
        }

        try {
            int index = Parser.extractIndex(userInput);
            if (index <= 0 || index > draftedEmails.size()) {
                throw new InvalidIndexException();
            }

            Email draftEmail = draftedEmails.get(index - 1);
            ui.printEditEmail();
            Scanner in = new Scanner(System.in);
            String editType = in.nextLine().trim();
            processEditCommand(draftEmail, in, editType);
            ui.printEmailEdited(editType);
        } catch (InvalidIndexException e) {
            e.showErrorMessage("EDIT");
        } catch (InvalidTypeException e) {
            ui.showMessageForInvalidEditTypeInput();
        } catch (IndexOutOfBoundsException e) {
            ui.showMessageForIndexOutOfBoundsException();
        }
    }

    private void processEditCommand(Email draftEmail, Scanner in, String editType) throws InvalidTypeException {
        switch (editType) {
        case "to":
            String to = in.nextLine();
            //draftEmail.setTo(to);
            break;
        case "subject":
            String subject = in.nextLine();
            draftEmail.setSubject(subject);
            break;
        case "content":
            String inputContent = in.nextLine();
            String content = inputContent + "\n";
            while (!inputContent.startsWith("end")) { //user unable to change contents of previous lines
                content += inputContent + "\n";
                inputContent = in.nextLine();
            }
            draftEmail.setContent(content);
            break;
        default:
            throw new InvalidTypeException();
        }

        String time = String.valueOf(LocalDateTime.now().withNano(0));
        draftEmail.setTime(time);
    }
}
