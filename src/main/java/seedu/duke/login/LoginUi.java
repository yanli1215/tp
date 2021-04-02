package seedu.duke.login;

import seedu.duke.utilities.Ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginUi extends Ui {

    public LoginInfo getNewUserLoginInfo() {
        LoginInfo loginInfo;
        while (true) {
            loginInfo = getUserInputForLogin();
            String check = "^(.+)@(.+)$";;
            Pattern p = Pattern.compile(check);
            Matcher m = p.matcher(loginInfo.getUserId());
            if (!m.find()) {
                printErrorMessage("Please enter a valid email address! \n"
                        + "Email address must have \"@\"");
                continue;
            }
            break;
        }
        return loginInfo;
    }

    public LoginInfo getLoginInfo() {
        LoginController loginController = new LoginController();
        LoginInfo loginInfo = null;
        printLoginMenu();
        Scanner sc = new Scanner(System.in);
        try {
            int choice = sc.nextInt();
            switch (choice) {
            case 1:
                loginInfo = getUserInputForLogin();
                break;
            case 2:
                loginInfo = loginController.addUser();
                break;
            case 3:
                printGoodBye();
                System.exit(0);
                break;
            default:
                break;
            }
        } catch(InputMismatchException e){
                printErrorMessage("You need to enter an integer! Please try again!");
                getLoginInfo();
        }
        return loginInfo;
    }
    public void printLoginMenu(){
        System.out.println(super.logo);
        System.out.println("Select either 1 or 2 (use numbers): \n"
                + "[Emails address are case sensitive!]\n"
                + "1. Log In \n"
                + "2. Create a new account\n"
                + "3. Exit");
    }

    public LoginInfo getUserInputForLogin() {
        Scanner sc = new Scanner(System.in);
        String userId;
        System.out.println("Enter email address:");
        userId = sc.next();
        System.out.println("Enter password:");
        String password = sc.next();
        return new LoginInfo(userId, password);
    }
}
