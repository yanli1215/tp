package seedu.duke.email;

import java.util.ArrayList;

public class Sent extends Email {
    public Sent(String from, String to, String subject, String time, String content) {
        super(from, to, subject, time, content);
    }

    public Sent(String from, ArrayList<String> to, String subject, String time, String content) {
        super(from, to, subject, time, content);
    }

    @Override
    public String getShortDescription() {
        return "[Sent]" + super.getShortDescription();
    }

}
