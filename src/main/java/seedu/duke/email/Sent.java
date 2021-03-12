package seedu.duke.email;

import seedu.duke.email.Email;

public class Sent extends Email {
    public Sent(String from, String to, String subject, String time, String content) {
        super(from, to, subject, time, content);
    }

    @Override
    public String toString() {
        return "[Sent]" + super.toString();
    }

}
