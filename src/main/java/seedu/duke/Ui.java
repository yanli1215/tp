package seedu.duke;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Ui {
    private final Scanner in;
    private final PrintStream out;
    private static final String logo = " _________   _____   _____   _____\n"
            + "|  _   _  | |  _  | |_   _| |  _  |\n"
            + "| | | | | | | | | |   | |   | | | |\n"
            + "| | | | | | | |_| |  _| |   | |_| |\n"
            + "|_| |_| |_| |_____| |___|   |_____|\n";


    public Ui() {
        this(System.in, System.out);
    }

    public Ui(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    public String getUserInput() {
        String inputLine = in.nextLine();
        while (inputLine.trim().isEmpty()) {
            inputLine = in.nextLine();
        }
        return inputLine;
    }

    private void printDivider() {
        System.out.println("____________________________________________________________");
    }

    public void printFeedback(String feedback) {
        System.out.println(feedback);
        printDivider();
    }

    public void printMenu() {
        System.out.println("Hello! I'm MojoHR\n" + logo + "What can I do for you?");
        System.out.println("> Use the keyword \"LIST (type) \" to print the emails by types");
        System.out.println("> Use the keyword \"HELP\" to print the menu");
        System.out.println("> Use the keyword \"BYE\" to exit");
        System.out.println("Enter your command: ");
    }
}
