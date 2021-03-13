package seedu.duke;

import seedu.duke.email.Archive;
import seedu.duke.email.Deleted;
import seedu.duke.email.Email;

import java.util.ArrayList;

public class EmailManager {
    private ArrayList<Email> emails = new ArrayList<>();

    public EmailManager(ArrayList<Email> emails) {
        this.emails = emails;
    }

    public EmailManager() {
        this.emails = new ArrayList<>();
    }

    public int getNumofEmails() {
        return emails.size();
    }

    public void listAllEmails() {
        for (int i = 0; i < emails.size(); i++) {
            System.out.println(i + 1 + ". " + emails.get(i));
            System.out.println("\n");
        }
    }

    public Email deleteEmail(int emailIndexShow){
        Email temp = emails.get(emailIndexShow - 1);
        emails.remove(emailIndexShow - 1);
        return temp;
    }

    public void addToDeleted(Email e) {
        Deleted email = new Deleted(e.getFrom(), e.getTo(), e.getSubject(), e.getTime(), e.getContent());
        emails.add(email);
    }

    public void addToArchive(Email e) {
        Archive email = new Archive(e.getFrom(), e.getTo(), e.getSubject(), e.getTime(), e.getContent());
        emails.add(email);
    }
}
