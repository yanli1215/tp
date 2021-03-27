package seedu.duke;

/**
 * This class is responsible for the login process.
 */
public class LoginController {
    private final LoginManager loginManager;
    private LoginUi loginUi;


    public LoginController(LoginManager loginManager) {
        loginUi = new LoginUi();
        this.loginManager = loginManager;
    }

    public LoginInfo run() {
        LoginInfo providedLoginInfo;
        providedLoginInfo = loginUi.getLoginInfo();
        loginManager.verifyLoginInfo(providedLoginInfo);
        return providedLoginInfo;
    }
}
