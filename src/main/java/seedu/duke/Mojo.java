package seedu.duke;

import org.json.simple.parser.ParseException;
import seedu.duke.Login.LoginController;
import seedu.duke.Login.LoginInfo;
import seedu.duke.Login.LoginInfoFileManager;
import seedu.duke.Login.LoginManager;
import seedu.duke.Utilities.Parser;
import seedu.duke.Utilities.Storage;
import seedu.duke.Utilities.Ui;
import seedu.duke.email.EmailManager;

import java.io.IOException;

public class Mojo {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    private static Ui ui;
    private static EmailManager emails;
    private static Parser parser;
    private Storage storage;

    public Mojo(String filePath, String account) {
        ui = new Ui();
        storage = new Storage(filePath, account);
        try {
            emails = new EmailManager(storage.load());
        } catch (IOException e) {
            emails = new EmailManager();
            e.printStackTrace();
        } catch (ParseException e) {
            emails = new EmailManager();
            e.printStackTrace();
        }
        parser = new Parser();
    }

    public void run() {
        ui.printMenu();
        while (true) {
            String userCommand = ui.getUserInput();
            try {
                parser.parse(userCommand.trim());
                parser.getCmd().execute(emails, ui, storage);
            } catch (AssertionError e) {
                ui.showMessageForInvalidCommandInput();
            }
        }
    }

    public static void main(String[] args) {
        LoginInfoFileManager loginInfoFileManager = new LoginInfoFileManager();
        LoginManager loginManager = new LoginManager(loginInfoFileManager);
        LoginController lc = new LoginController(loginManager);
        LoginInfo providedLoginInfo = lc.run();
        String userId  = providedLoginInfo.getUserId();
        new Mojo(userId + ".json", userId).run();

    }
}


