package seedu.duke.command;

import seedu.duke.EmailManager;
import seedu.duke.Parser;
import seedu.duke.Storage;
import seedu.duke.Ui;
import seedu.duke.email.Draft;
import seedu.duke.email.Email;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class ComposeCommand extends Command {

    public ComposeCommand(String s) {
        super(s);
    }

    public void execute(EmailManager emails, Ui ui, Storage storage) {
        try {
            Scanner in = new Scanner(System.in);
            ui.printComposeUI();
            ArrayList<String> to = Parser.parseRecipients(in.nextLine());
            String subject = in.nextLine();
            String inputContent = in.nextLine();
            String content = inputContent + "\n";
            while (!inputContent.startsWith("end")) { //user unable to change contents of previous lines
                content += inputContent + "\n";
                inputContent = in.nextLine();
            }
            String userEmail = "12312@gmail.com";
            String time = String.valueOf(LocalDateTime.now().withNano(0));
            Email draftEmail = new Draft(userEmail, to, subject, time, content);
            emails.addToDraft(draftEmail);
            ui.printEmailDrafted(draftEmail);
        } catch (NullPointerException e) {
            System.out.println("Draft not saved due to missing line");
        }
    }

}
