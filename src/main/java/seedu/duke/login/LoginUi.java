package seedu.duke.login;

import seedu.duke.utilities.Ui;

import java.util.Scanner;

public class LoginUi extends Ui {

    public LoginInfo getLoginInfo() {
        Scanner sc = new Scanner(System.in);
        String userId;
        System.out.println("Enter email address:");
        userId = sc.next();
        System.out.println("Enter password:");
        String password = sc.next();
        return new LoginInfo(userId, password);
    }
}
