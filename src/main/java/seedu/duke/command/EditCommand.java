package seedu.duke.command;

import com.sun.jdi.InvalidTypeException;
import seedu.duke.EmailManager;
import seedu.duke.Parser;
import seedu.duke.Storage;
import seedu.duke.Ui;
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
            String feedback = "What would you like to edit? It must be one of [to, subject, content].";
            ui.printFeedback(feedback);
            Scanner in = new Scanner(System.in);
            String editType = in.nextLine().trim();
            processEditCommand(draftEmail, in, editType);
            ui.showMessageForEditCompleted(editType);
        } catch (InvalidIndexException e) {
            e.showErrorMessage("EDIT");
        } catch (InvalidTypeException e) {
            ui.showMessageForInvalidEditTypeInput();
        }
    }

    private void processEditCommand(Email draftEmail, Scanner in, String editType) throws InvalidTypeException {
        switch (editType) {
        case "to":
            String to = in.nextLine();
            draftEmail.setTo(to);
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
