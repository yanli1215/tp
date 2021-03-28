package seedu.duke.Login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginInfoFileManager {
    private File loginInfoFile;

    public LoginInfoFileManager() {
        loginInfoFile = new File("data/LoginInfo.txt");
    }

    // Register new user
    public void addLoginInfoForUser(LoginInfo loginInfo) {
        try {
            FileWriter fw = new FileWriter(loginInfoFile, true);
            fw.write(loginInfo.getUserId() + "|" + loginInfo.getPassword() + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Retrieve user login info
    public ArrayList<LoginInfo> retrieveLoginInfoList() {
        ArrayList<LoginInfo> loginInfoList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(loginInfoFile);
            while (sc.hasNext()) {
                String[] lineSplit = sc.nextLine().split("\\|");
                loginInfoList.add(new LoginInfo(lineSplit[0], lineSplit[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return loginInfoList;
    }

}

