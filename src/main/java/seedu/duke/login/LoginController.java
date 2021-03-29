package seedu.duke.login;

import seedu.duke.exceptions.WrongLoginInfoException;

/**
 * This class is responsible for the login process.
 */
public class LoginController {
    private LoginManager loginManager;
    private LoginUi loginUi;
    private static LoginInfo loginInfo;

    public LoginController() {
        loginManager = new LoginManager();
        loginUi = new LoginUi();
    }

    public LoginInfo run() {
        LoginInfo providedLoginInfo;
        providedLoginInfo = loginUi.getLoginInfo();
        try {
            loginManager.verifyLoginInfo(providedLoginInfo);
        } catch (NullPointerException | WrongLoginInfoException e) {
            loginUi.printErrorMessage(e.getMessage());
        }
        return providedLoginInfo;
    }

    public void modifyLoginInfo(String emailAccount, String newPwd) {
        LoginInfo loginInfo = new LoginInfo(emailAccount, newPwd);
        loginManager.modifyLoginInfo(loginInfo);
    }
}
