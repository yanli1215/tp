package seedu.duke.email;

import seedu.duke.email.Email;

import java.util.ArrayList;

public class Junk extends Email {
    public Junk(String from, String to, String subject, String time, String content) {
        super(from, to, subject, time, content);
    }

    public Junk(String from, ArrayList<String> to, String subject, String time, String content) {
        super(from, to, subject, time, content);
    }

    @Override
    public String getShortDescription() {
        return "[Junk]" + super.getShortDescription();
    }

}
