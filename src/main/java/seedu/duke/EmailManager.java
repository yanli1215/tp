package seedu.duke;

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

    public void listAllEmails() {
        for(int i=0; i< emails.size() ; i++) {
            System.out.println(i+1 + ". " + emails.get(i));
            System.out.println("\n");
        }
    }
}
