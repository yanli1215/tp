package seedu.duke;

import java.io.Console;
import java.util.Scanner;

public class LoginUi extends Ui {

    public LoginInfo getLoginInfo() {
        Scanner sc = new Scanner(System.in);
        //Console con = System.console();
        String userId;
        char[] passwordCharArray;
        String passwordString;
        //String password;
        System.out.println("Enter email address:");
        userId = sc.next();
        System.out.println("Enter password:");
        String password = sc.next();
        //passwordCharArray = con.readPassword();
        //passwordString = String.valueOf(passwordCharArray);
        return new LoginInfo(userId, password);
    }
}
