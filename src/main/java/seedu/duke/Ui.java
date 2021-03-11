package seedu.duke;

import java.util.Scanner;

public class Ui {
    private static final Scanner scanner = new Scanner(System.in);

    public String getUserInput() {
        String input;
        do {
            input = scanner.nextLine();
        } while (input.trim().isEmpty());
        printDivider();
        return input;
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
