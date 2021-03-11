package seedu.duke;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Ui {
    private final Scanner in;
    private final PrintStream out;

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

    public void showHello() {
        String logo = " _________   _____   _____   _____\n"
                + "|  _   _  | |  _  | |_   _| |  _  |\n"
                + "| | | | | | | | | |   | |   | | | |\n"
                + "| | | | | | | |_| |  _| |   | |_| |\n"
                + "|_| |_| |_| |_____| |___|   |_____|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?");
    }
}
