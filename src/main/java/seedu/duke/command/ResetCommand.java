package seedu.duke.command;

import seedu.duke.EmailManager;
import seedu.duke.Storage;
import seedu.duke.Ui;

public class ResetCommand extends Command {
    public ResetCommand(String s) {
        super(s);
    }

    public void execute(EmailManager emails, Ui ui, Storage storage) {
        int n = 3;
        while (n > 0) {
            String userInputPwd = ui.getResetPsw("old");
            String oldPwd = storage.getPwd();
            if (userInputPwd.trim().equals(oldPwd.trim())) {
                String newPwd = ui.getResetPsw("new");
                storage.changePWD(newPwd.trim());
                System.out.println("Your password has changed successfully!");
                break;
            }
            n--;
            System.out.println("Sorry your old password is wrong. Please try again!(" + n + " times left!)");
            ui.printDivider();
        }
    }

}
