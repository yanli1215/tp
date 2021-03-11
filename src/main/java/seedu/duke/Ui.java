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
}
