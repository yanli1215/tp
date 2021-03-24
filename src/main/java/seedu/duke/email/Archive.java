package seedu.duke.email;

import java.util.ArrayList;

public class Archive extends Email {
    public Archive(String from, String to, String subject, String time, String content) {
        super(from, to, subject, time, content);
    }

    public Archive(String from, ArrayList<String> to, String subject, String time, String content) {
        super(from, to, subject, time, content);
    }

    @Override
    public String getShortDescription() {
        return "[Archive]" + super.getShortDescription();
    }
}
