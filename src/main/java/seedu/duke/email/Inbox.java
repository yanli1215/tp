package seedu.duke.email;

import seedu.duke.email.Email;

public class Inbox extends Email {
    public Inbox(String from, String to, String subject, String time, String content) {
        super(from, to, subject, time, content);
    }

    @Override
    public String toString() {
        return "[Inbox]" + super.toString();
    }

}
