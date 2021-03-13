package seedu.duke;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */

    private static Ui ui;
    private static EmailManager emails;
    private static Parser p;
    private Storage storage;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            emails = new EmailManager(storage.load());
        } catch (IOException e) {
            emails = new EmailManager();
            e.printStackTrace();
        } catch (ParseException e) {
            emails = new EmailManager();
            e.printStackTrace();
        }
        p = new Parser();
    }

    public void run() {
        ui.showHello();
        while (true) {
            String userCommand = ui.getUserInput();
            p.parse(userCommand.trim());
            p.getCmd().execute(emails, ui, storage);
        }
    }

    public static void main(String[] args) {
        new Duke("test.json").run();
    }
}


