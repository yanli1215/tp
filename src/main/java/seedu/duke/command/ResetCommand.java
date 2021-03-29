package seedu.duke.command;

import seedu.duke.login.LoginInfo;
import seedu.duke.login.LoginInfoFileManager;
import seedu.duke.login.LoginManager;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;
import seedu.duke.email.EmailManager;

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
                String newPwd = ui.getResetPsw("new").trim();
                storage.changePwd(newPwd);
                LoginInfoFileManager loginInfoFileManager = new LoginInfoFileManager();
                LoginManager loginManager = new LoginManager(loginInfoFileManager);
                LoginInfo newLogin = new LoginInfo(storage.getEmailAccount(), newPwd);
                loginManager.modifyLoginInfo(newLogin);
                System.out.println("Your password has changed successfully!");
                break;
            }
            n--;
            System.out.println("Sorry your old password is wrong. Please try again!(" + n + " times left!)");
            ui.printDivider();
        }
    }

}
