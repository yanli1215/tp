package seedu.duke.email;

import seedu.duke.email.Email;

import java.util.ArrayList;

public class Inbox extends Email {
    public Inbox(String from, String to, String subject, String time, String content) {
        super(from, to, subject, time, content);
    }

    public Inbox(String from, ArrayList<String> to, String subject, String time, String content) {
        super(from, to, subject, time, content);
    }

    @Override
    public String getShortDescription() {
        return "[Inbox]" + super.getShortDescription();
    }

}
