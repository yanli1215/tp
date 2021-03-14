package seedu.duke.command;

import org.json.simple.JSONObject;

import java.util.Scanner;
import java.time.LocalDateTime;

import seedu.duke.EmailManager;
import seedu.duke.Storage;
import seedu.duke.Ui;
import seedu.duke.email.Draft;
import seedu.duke.email.Email;

public class ComposeCommand extends Command {

    public ComposeCommand(String s) {
        super(s);
    }

    public void execute(EmailManager tasks, Ui ui, Storage storage) {
        try {
            Scanner in = null;
            ui.printComposeUI();
            String to = in.nextLine();
            String subject = in.nextLine();
            String inputContent = in.nextLine();
            String content = inputContent + "\n";
            while (inputContent != null) { //user unable to change contents of previous lines
                content += inputContent + "\n";
                inputContent = in.nextLine();
            }
            String userEmail = "12312@gmail.com";
            String time = String.valueOf(LocalDateTime.now());
            Email draftEmail = new Draft(userEmail, to, subject, time, content);
            ui.printEmailDraft(draftEmail);
        } catch (NullPointerException e) {
            System.out.println("Draft not saved due to missing line");
        }


        /* JSONObject newEmail = new JSONObject();
        newEmail.put("from", userEmail);
        newEmail.put("to", to);
        newEmail.put("subject", subject);
        newEmail.put("time", time);
        newEmail.put("content", content);*/
    }

}
