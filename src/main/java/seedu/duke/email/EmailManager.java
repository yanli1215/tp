package seedu.duke.email;

import java.util.ArrayList;
import java.util.Comparator;

import static java.util.stream.Collectors.toList;

public class EmailManager {


    private ArrayList<Email> emailsList = new ArrayList<>();
    private ArrayList<Email> listedEmailsList = null;
    private String listedType = "null";

    public ArrayList<Email> getEmailsList() {
        return emailsList;
    }

    public void setListedEmailsList(ArrayList<Email> listedEmailsList) {
        this.listedEmailsList = listedEmailsList;
    }

    public void setEmailsList(ArrayList<Email> listedEmailsList) {
        this.emailsList = listedEmailsList;
    }

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

    public void printEmailByType(ArrayList<Email> emailTypeToPrint) {
        for (int i = 0; i < emailTypeToPrint.size(); i++) {
            System.out.println(i + 1 + ". " + emailTypeToPrint.get(i).getShortDescription());
        }
        listedEmailsList = emailTypeToPrint;
    }

    public void setListedType(String emailType) {
        listedType = emailType;
    }

    public String getListedType() {
        return listedType;
    }

    public void sortBySender() {
        emailsList.sort(new TypeSenderSortingComparator());
    }

    private class TypeSenderSortingComparator implements Comparator<Email> {
        @Override
        public int compare(Email email1, Email email2) {
            return email1.getFrom().compareTo(email2.getFrom());
        }
    }

    public void sortByTime() {
        emailsList.sort(new TypeTimeSortingComparator());
    }

    private class TypeTimeSortingComparator implements Comparator<Email> {
        @Override
        public int compare(Email email1, Email email2) {
            return email1.getTime().compareTo(email2.getTime());
        }
    }

    public ArrayList<Email> getArchivedEmails() {
        ArrayList<Email> archivesList = new ArrayList<>();
        for (Email email : emailsList) {
            if (email instanceof Archive) {
                archivesList.add(email);
            }
        }
        return archivesList;
    }

    public ArrayList<Email> getDeletedEmails() {
        ArrayList<Email> deletedList = new ArrayList<>();
        for (Email email : emailsList) {
            if (email instanceof Deleted) {
                deletedList.add(email);
            }
        }
        return deletedList;
    }

    public ArrayList<Email> getDraftEmails() {
        ArrayList<Email> draftsList = new ArrayList<>();
        for (Email email : emailsList) {
            if (email instanceof Draft) {
                draftsList.add(email);
            }
        }
        return draftsList;
    }

    public ArrayList<Email> getInboxEmails() {
        ArrayList<Email> inboxList = new ArrayList<>();
        for (Email email : emailsList) {
            if (email instanceof Inbox) {
                inboxList.add(email);
            }
        }
        return inboxList;
    }

    public ArrayList<Email> getJunkEmails() {
        ArrayList<Email> junkList = new ArrayList<>();
        for (Email email : emailsList) {
            if (email instanceof Junk) {
                junkList.add(email);
            }
        }
        return junkList;
    }

    public ArrayList<Email> getSentEmails() {
        ArrayList<Email> sentList = new ArrayList<>();
        for (Email email : emailsList) {
            if (email instanceof Sent) {
                sentList.add(email);
            }
        }
        return sentList;
    }

    public ArrayList<Email> getAllEmails() {
        return emailsList;
    }

    public ArrayList<Email> getListedEmailsList() {
        return listedEmailsList;
    }

    public void deleteEmail(Email e) {
        emailsList.remove(e);
    }

    public void addToDeleted(Email e) {
        Deleted email = new Deleted(e.getFrom(), e.getTo(), e.getSubject(), e.getTime(), e.getContent(), e.isRead());
        emailsList.add(email);
    }

    public void addToSent(Email e) {
        Sent email = new Sent(e.getFrom(), e.getTo(), e.getSubject(), e.getTime(), e.getContent(), e.isRead());
        emailsList.add(email);
    }

    public void addToArchive(Email e) {
        Archive email = new Archive(e.getFrom(), e.getTo(), e.getSubject(), e.getTime(), e.getContent(), e.isRead());
        emailsList.add(email);
    }

    public void addToDraft(Email e) {
        Draft email = new Draft(e.getFrom(), e.getTo(), e.getSubject(), e.getTime(), e.getContent(), e.isRead());
        emailsList.add(email);
    }

    public void addToInbox(Email e) {
        Inbox email = new Inbox(e.getFrom(), e.getTo(), e.getSubject(), e.getTime(), e.getContent(), e.isRead());
        emailsList.add(email);
    }

    public ArrayList<Email> findByString(ArrayList<Email> emails, String filterString) {
        ArrayList<Email> filteredList = (ArrayList<Email>) emails.stream()
                .filter((s) -> (s.getContent().toLowerCase().contains(filterString) || s.getSubject().toLowerCase()
                        .contains(filterString)))
                .collect(toList());
        return filteredList;
    }

}