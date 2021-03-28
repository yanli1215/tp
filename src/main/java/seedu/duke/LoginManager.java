package seedu.duke;

import seedu.duke.exceptions.WrongLoginInfoException;

import java.util.ArrayList;

/**
 * Provides logic to verify users login.
 */
public class LoginManager {

    private LoginInfoFileManager loginInfoFileManager;

    public LoginManager(LoginInfoFileManager loginInfoFileManager) {
        this.loginInfoFileManager = loginInfoFileManager;
    }

    public void verifyLoginInfo(LoginInfo providedLoginInfo) throws WrongLoginInfoException {
        ArrayList<LoginInfo> loginInfoList = loginInfoFileManager.retrieveLoginInfoList();
        for (LoginInfo loginInfo: loginInfoList) {
            if (loginInfo.equals(providedLoginInfo)) {
                return;
            }
        }
        throw new WrongLoginInfoException();
    }
}
