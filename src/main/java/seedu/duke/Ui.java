package seedu.duke;

import seedu.duke.email.Email;

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
        printDivider();
        System.out.println("Enter Command:");
        String inputLine = in.nextLine();
        while (inputLine.trim().isEmpty()) {
            inputLine = in.nextLine();
        }
        printDivider();
        return inputLine;
    }

    public void printComposeUI() {
        printDivider();
        System.out.println("Please enter the details below in the correct order:");
        System.out.println("To:");
        System.out.println("Subject:");
        System.out.println("Content:");
        printDivider();
    }

    private void printDivider() {
        System.out.println("____________________________________________________________");
    }

    public void printEmailDraft(Email email) {
        printDivider();
        System.out.println("Email saved to draft " + "at " + email.getTime());
        printDivider();
    }

    public void printEmailSent(Email email) {
        printDivider();
        System.out.println("Email successfully sent to: " + email.getTo() + " at " + email.getTime());
        printDivider();
    }

    public void printFeedback(String feedback) {
        System.out.println(feedback);
        printDivider();
    }

    public void printMenu() {
        System.out.println("Hello! I'm MojoHR\n" + logo + "What can I do for you?");
        System.out.println("> Use the keyword \"LIST (type) \" to print the emails by types");
        System.out.println("> Use the keyword \"READ (index) \" to open the selected email");
        System.out.println("> Use the keyword \"SEND (recipient's email address) (subject) (body) \" to send email");
        System.out.println("> Use the keyword \"DELETE (index) \" to delete the selected email");
        System.out.println("> Use the keyword \"ARCHIVE (index) \" to move the selected email to the archive folder");
        System.out.println("> Use the keyword \"HELP\" to print the menu");
        System.out.println("> Use the keyword \"BYE\" to exit");
    }

    public static void showInvalidIdMessage(String type) {
        System.out.println("OOPS!!! The Email ID that you " + type + " is invalid.");
    }

    public void showMessageForInvalidCommandInput() {
        System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(!");
    }

    public static void showInvalidListTypeMessage() {
        System.out.println("OOPS!!! The Email type that you enter is invalid.");
        System.out.println("It must be one of: [emails, inbox, archive, deleted, draft, junk, sent]");
    }
}
