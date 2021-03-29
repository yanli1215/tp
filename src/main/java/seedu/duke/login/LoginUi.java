package seedu.duke.login;

import seedu.duke.utilities.Ui;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginUi extends Ui {

    public LoginInfo getNewUserLoginInfo() {
        LoginInfo loginInfo;
        while (true) {
            loginInfo = getUserInputForLogin();
            String ePattern = "^(.+)@(.+)$";;
            Pattern p = Pattern.compile(ePattern);
            Matcher m = p.matcher(loginInfo.getUserId());
            if (!m.find()) {
                printErrorMessage("Please enter a valid email address!");
                continue;
            }
            break;
        }
        return loginInfo;
    }

    public LoginInfo getLoginInfo() {
        LoginController loginController = new LoginController();
        System.out.println(super.logo);
        System.out.println("Select either 1 or 2 (use numbers): \n" +
                "1. Log In \n" +
                "2. Create a new account" );
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        try {
            switch (choice) {
            case 1:
                return getUserInputForLogin();
            case 2:
                return loginController.addUser();
            default:
                assert false;
            }
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public LoginInfo getUserInputForLogin(){
        Scanner sc = new Scanner(System.in);
        String userId;
        System.out.println("Enter email address:");
        userId = sc.next();
        System.out.println("Enter password:");
        String password = sc.next();
        return new LoginInfo(userId, password);
    }
}
