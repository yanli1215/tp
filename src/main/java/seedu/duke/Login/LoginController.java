package seedu.duke.Login;

import seedu.duke.exceptions.WrongLoginInfoException;

/**
 * This class is responsible for the login process.
 */
public class LoginController {
    private final LoginManager loginManager;
    private LoginUi loginUi;
    private static LoginInfo loginInfo;


    public LoginController(LoginManager loginManager) {
        loginUi = new LoginUi();
        this.loginManager = loginManager;
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
}
