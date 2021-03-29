package seedu.duke.login;

import seedu.duke.utilities.Ui;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginUi extends Ui {

    public static LoginInfo getNewUserLoginInfo() {
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

    public static LoginInfo getUserInputForLogin(){
        Scanner sc = new Scanner(System.in);
        String userId;
        System.out.println("Enter email address:");
        userId = sc.next();
        System.out.println("Enter password:");
        String password = sc.next();
        return new LoginInfo(userId, password);
    }
}
