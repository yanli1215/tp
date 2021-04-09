package seedu.duke.login;

import seedu.duke.exceptions.WrongLoginInfoException;

import java.util.Scanner;

/**
 * This class is responsible for the login process.
 */
public class LoginController {
    private LoginManager loginManager;
    private LoginUi loginUi;
    private LoginInfo loginInfo;
    private LoginInfoFileManager loginInfoFileManager;

    public LoginController() {
        loginManager = new LoginManager();
        loginUi = new LoginUi();
        loginInfoFileManager = new LoginInfoFileManager();
    }

    public LoginInfo run() {
        LoginInfo providedLoginInfo;
        providedLoginInfo = loginUi.getLoginInfo();
        while (true) {
            try {
                loginManager.verifyLoginInfo(providedLoginInfo);
                break;
            } catch (NullPointerException | WrongLoginInfoException e) {
                loginUi.printErrorMessage(e.getMessage());
                providedLoginInfo = loginUi.getLoginInfo();
            }
        }
        return providedLoginInfo;
    }


    public void modifyLoginInfo(String emailAccount, String newPwd) {
        LoginInfo loginInfo = new LoginInfo(emailAccount, newPwd);
        loginManager.modifyLoginInfo(loginInfo);
    }

    public LoginInfo addUser() {
        LoginInfo loginInfo;
        loginInfo = loginUi.getNewUserLoginInfo();
        if (checkUserIdExists(loginInfo.getUserId())) {
            loginUi.printErrorMessage("You already have an account. Please log in instead!");
            loginUi.getLoginInfo();
        }
        loginInfoFileManager.addLoginInfoForNewUser(loginInfo);
        return loginInfo;
    }


    public boolean checkUserIdExists(String userId) {
        for (LoginInfo loginInfo: loginInfoFileManager.retrieveLoginInfoList()) {
            if (loginInfo.getUserId().equals(userId)) {
                return true;
            }
        }
        return false;
    }
}
