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
<<<<<<< HEAD
        for (LoginInfo loginInfo: loginInfoList) {
=======
        for (LoginInfo loginInfo : loginInfoList) {
>>>>>>> bff4bbdcdd5f63268b3718b201aaaca6043912d5
            assert loginInfo != null : "loginInfo is null";
            if (loginInfo.equals(providedLoginInfo)) {
                return;
            }
        }
        throw new WrongLoginInfoException();
    }

    public void modifyLoginInfo(LoginInfo newLogInfo) {
        ArrayList<LoginInfo> loginInfoList = loginInfoFileManager.retrieveLoginInfoList();
        for (LoginInfo loginInfo : loginInfoList) {
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
