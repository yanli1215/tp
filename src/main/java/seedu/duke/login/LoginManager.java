package seedu.duke.login;

import seedu.duke.exceptions.WrongLoginInfoException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Provides logic to verify users login.
 */
public class LoginManager {

    private LoginInfoFileManager loginInfoFileManager;
    private LoginController loginController;

    public LoginManager() {
        loginInfoFileManager = new LoginInfoFileManager();
    }

    public void verifyLoginInfo(LoginInfo providedLoginInfo) throws WrongLoginInfoException {
        loginController = new LoginController();
        ArrayList<LoginInfo> loginInfoList = loginInfoFileManager.retrieveLoginInfoList();
        for (LoginInfo loginInfo: loginInfoList) {
            if (loginInfo.equals(providedLoginInfo)) {
                return;
            }
        }
        if(!loginController.checkUserIdExists(providedLoginInfo.getUserId())) {
            System.out.println("You already have account. Please Log in instead!");
        }else {
            throw new WrongLoginInfoException();
        }
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
