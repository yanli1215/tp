package seedu.duke;

import java.util.Scanner;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */

    private static Ui ui = new Ui();
    private static EmailManager emailManager = new EmailManager();
    private static Parser parser = new Parser();

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());

        while (true) {
            String input = ui.getUserInput();
            String feedback = executeCommand(input);
            ui.printFeedback(feedback);
        }

    }

    private static String executeCommand(String input) {

        String[] parsedInput = parser.parseCommand(input);

        String command = parsedInput[0];
        String description = parsedInput[1];

        String feedback = "";

        switch (command) {

        default:

        }

        return feedback;
    }
}
