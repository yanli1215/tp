package seedu.duke;

import java.util.Scanner;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */

//    private static Ui ui;
//    private static EmailManager emails = new EmailManager();
//    private static Parser p;
//    private Storage storage;

//    public Duke(String filePath) {
//        ui = new Ui();
//        storage = new Storage(filePath);
//        //this.emails = new EmailManager(storage.load());
//        p = new Parser();
//    }
//
//    public void run() {
//        //ui.showHello();
//        //while (true) {
//        //String userCommand = ui.getUserInput();
//        //p.parse(userCommand.trim());
//        //p.getCmd().execute(tasks, ui, storage);
//        }
//    }

    public static void main(String[] args) {
        Storage storage = new Storage("test.json");
        storage.readJson();
    }
}


