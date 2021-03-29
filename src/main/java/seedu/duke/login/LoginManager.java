package seedu.duke.login;

import seedu.duke.exceptions.WrongLoginInfoException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Provides logic to verify users login.
 */
public class LoginManager {

    private LoginInfoFileManager loginInfoFileManager;

    public LoginManager() {
        loginInfoFileManager = new LoginInfoFileManager();
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

    public void modifyLoginInfo(LoginInfo newLogInfo) {
        ArrayList<LoginInfo> loginInfoList = loginInfoFileManager.retrieveLoginInfoList();
        for (LoginInfo loginInfo: loginInfoList) {
            if (loginInfo.getUserId().equals(newLogInfo.getUserId())) {
                loginInfo.setPassword(newLogInfo.getPassword());
                break;
            }
        }
        try {
            loginInfoFileManager.writeToTxt(loginInfoList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
