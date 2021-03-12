package seedu.duke;

import seedu.duke.email.*;

import java.util.ArrayList;

public class EmailManager {
    private static ArrayList<Email> emailsList = new ArrayList<>();


    public EmailManager(ArrayList<Email> emailsList) {
        this.emailsList = emailsList;
    }

    public EmailManager() {
        this.emailsList = new ArrayList<>();
    }

    public void printEmailByType(ArrayList emailTypeToPrint) {
        for (int i = 0; i < emailTypeToPrint.size(); i++) {
            System.out.println(i + 1 + ". " + emailTypeToPrint.get(i));
            System.out.println("\n");
        }
        System.out.println("Enter Command: ");
    }

    public static ArrayList<Email> getArchivedEmails() {
        ArrayList<Email> archivesList = new ArrayList<>();
        for (Email email : emailsList) {
            if (email instanceof Archive) {
                archivesList.add(email);
            }
        }
        return archivesList;
    }

    public static ArrayList<Email> getDeletedEmails() {
        ArrayList<Email> deletedList = new ArrayList<>();
        for (Email email : emailsList) {
            if (email instanceof Deleted) {
                deletedList.add(email);
            }
        }
        return deletedList;
    }

    public static ArrayList<Email> getDraftEmails() {
        ArrayList<Email> draftsList = new ArrayList<>();
        for (Email email : emailsList) {
            if (email instanceof Draft) {
                draftsList.add(email);
            }
        }
        return draftsList;
    }

    public static ArrayList<Email> getInboxEmails() {
        ArrayList<Email> inboxList = new ArrayList<>();
        for (Email email : emailsList) {
            if (email instanceof Inbox) {
                inboxList.add(email);
            }
        }
        return inboxList;
    }

    public static ArrayList<Email> getJunkEmails() {
        ArrayList<Email> junkList = new ArrayList<>();
        for (Email email : emailsList) {
            if (email instanceof Junk) {
                junkList.add(email);
            }
        }
        return junkList;
    }

    public static ArrayList<Email> getSentEmails() {
        ArrayList<Email> sentList = new ArrayList<>();
        for (Email email : emailsList) {
            if (email instanceof Sent) {
                sentList.add(email);
            }
        }
        return sentList;
    }

    public static ArrayList<Email> getAllEmails() {
        return emailsList;
    }
}
