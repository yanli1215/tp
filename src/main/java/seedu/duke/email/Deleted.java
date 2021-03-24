package seedu.duke.email;

import java.util.ArrayList;

public class Deleted extends Email {
    public Deleted(String from, String to, String subject, String time, String content) {
        super(from, to, subject, time, content);
    }

    public Deleted(String from, ArrayList<String> to, String subject, String time, String content) {
        super(from, to, subject, time, content);
    }

    @Override
    public String getShortDescription() {
        return "[Deleted]" + super.getShortDescription();
    }

}
