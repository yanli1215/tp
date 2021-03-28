package seedu.duke;

import java.util.ArrayList;

/**
 * Provides logic to verify users login.
 */
public class LoginManager {

    private LoginInfoFileManager loginInfoFileManager;

    public LoginManager(LoginInfoFileManager loginInfoFileManager) {
        this.loginInfoFileManager = loginInfoFileManager;
    }

    public void verifyLoginInfo(LoginInfo providedLoginInfo) {
        ArrayList<LoginInfo> loginInfoList = loginInfoFileManager.retrieveLoginInfoList();
        for (LoginInfo loginInfo: loginInfoList) {
            if (loginInfo.equals(providedLoginInfo)) {
                return;
            }
        }
    }
}
