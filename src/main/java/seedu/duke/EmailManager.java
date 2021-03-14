package seedu.duke;

import seedu.duke.email.Archive;
import seedu.duke.email.Deleted;
import seedu.duke.email.Draft;
import seedu.duke.email.Email;
import seedu.duke.email.Inbox;
import seedu.duke.email.Junk;
import seedu.duke.email.Sent;

import java.util.ArrayList;

public class EmailManager {
    private static ArrayList<Email> emailsList = new ArrayList<>();
    private static ArrayList<Email> listedEmailsList = null;

    public EmailManager(ArrayList<Email> emailsList) {
        this.emailsList = emailsList;
    }

    public EmailManager() {
        this.emailsList = new ArrayList<>();
    }


    public int getNumOfEmails() {
        return emailsList.size();
    }

    public int getNumOfArchiveEmails() {
        int numberOfEmails = 0;
        for (Email email : emailsList) {
            if (email instanceof Archive) {
                numberOfEmails++;
            }
        }
        return numberOfEmails;
    }

    public int getNumOfDeletedEmails() {
        int numberOfEmails = 0;
        for (Email email : emailsList) {
            if (email instanceof Deleted) {
                numberOfEmails++;
            }
        }
        return numberOfEmails;
    }

    public int getNumOfDraftEmails() {
        int numberOfEmails = 0;
        for (Email email : emailsList) {
            if (email instanceof Draft) {
                numberOfEmails++;
            }
        }
        return numberOfEmails;
    }

    public int getNumOfInboxEmails() {
        int numberOfEmails = 0;
        for (Email email : emailsList) {
            if (email instanceof Inbox) {
                numberOfEmails++;
            }
        }
        return numberOfEmails;
    }

    public int getNumOfJunkEmails() {
        int numberOfEmails = 0;
        for (Email email : emailsList) {
            if (email instanceof Junk) {
                numberOfEmails++;
            }
        }
        return numberOfEmails;
    }

    public int getNumOfSentEmails() {
        int numberOfEmails = 0;
        for (Email email : emailsList) {
            if (email instanceof Sent) {
                numberOfEmails++;
            }
        }
        return numberOfEmails;
    }

    public void listAllEmails() {
        for (int i = 0; i < emailsList.size(); i++) {
            System.out.println(i + 1 + ". " + emailsList.get(i));
        }
    }

    public void printEmailByType(ArrayList<Email> emailTypeToPrint) {
        for (int i = 0; i < emailTypeToPrint.size(); i++) {
            System.out.println(i + 1 + ". " + emailTypeToPrint.get(i).getShortDescription());
        }
        listedEmailsList = emailTypeToPrint;
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

    public static ArrayList<Email> getListedEmailsList() {
        return listedEmailsList;
    }

    public void deleteEmail(Email e) {
        emailsList.remove(e);
    }

    public void addToDeleted(Email e) {
        Deleted email = new Deleted(e.getFrom(), e.getTo(), e.getSubject(), e.getTime(), e.getContent());
        emailsList.add(email);
    }

    public void addToSent(Email e) {
        Sent email = new Sent(e.getFrom(), e.getTo(), e.getSubject(), e.getTime(), e.getContent());
        emailsList.add(email);
    }

    public void addToArchive(Email e) {
        Archive email = new Archive(e.getFrom(), e.getTo(), e.getSubject(), e.getTime(), e.getContent());
        emailsList.add(email);
    }


}