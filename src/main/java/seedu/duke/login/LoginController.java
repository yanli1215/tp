package seedu.duke.login;

import seedu.duke.exceptions.WrongLoginInfoException;

import java.util.Scanner;

/**
 * This class is responsible for the login process.
 */
public class LoginController {
    private LoginManager loginManager;
    private LoginUi loginUi;
    private static LoginInfo loginInfo;
    private LoginInfoFileManager loginInfoFileManager;

    public LoginController() {
        loginManager = new LoginManager();
        loginUi = new LoginUi();
    }

    public LoginInfo run() {
        LoginInfo providedLoginInfo;
        providedLoginInfo = getLoginInfo();
        while(true) {
            try {
                loginManager.verifyLoginInfo(providedLoginInfo);
                break;
            } catch (NullPointerException | WrongLoginInfoException e) {
                loginUi.printErrorMessage(e.getMessage());
                providedLoginInfo = getLoginInfo();
            }
        }
        return providedLoginInfo;
    }

    public LoginInfo getLoginInfo() {
        System.out.println("Select either 1 or 2 (use numbers): \n" +
                "1. Log In \n" +
                "2. Create a new account" );
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        try {
            switch (choice) {
            case 1:
                return loginUi.getUserInputForLogin();
            case 2:
                return addUser();
            default:
                assert false;
            }
        }catch (NullPointerException e){
            System.out.println("Null pointer");
        }
        return null;
    }

    public void modifyLoginInfo(String emailAccount, String newPwd) {
        LoginInfo loginInfo = new LoginInfo(emailAccount, newPwd);
        loginManager.modifyLoginInfo(loginInfo);
    }

    public LoginInfo addUser(){
        LoginInfo loginInfo;
        loginInfo = loginUi.getNewUserLoginInfo();
        if (checkUserIdExists(loginInfo.getUserId())) {
            loginUi.printErrorMessage("You already have an account. Please log in instead!");
            getLoginInfo();
        }
        LoginInfoFileManager loginInfoFileManager = new LoginInfoFileManager();
        loginInfoFileManager.addLoginInfoForNewUser(loginInfo);
        return loginInfo;
    }

    private static boolean checkUserIdExists(String userId) {
        LoginInfoFileManager loginInfoFileManager = new LoginInfoFileManager();
        for (LoginInfo loginInfo: loginInfoFileManager.retrieveLoginInfoList()) {
            if (loginInfo.getUserId().equals(userId)) {
                return true;
            }
        }
        return false;
    }





}
