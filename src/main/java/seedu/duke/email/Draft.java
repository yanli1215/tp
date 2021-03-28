package seedu.duke.email;

import java.util.ArrayList;

public class Draft extends Email {
    public Draft(String from, String to, String subject, String time, String content) {
        super(from, to, subject, time, content);
    }

    public Draft(String from, ArrayList<String> to, String subject, String time, String content) {
        super(from, to, subject, time, content);
    }

    @Override
    public String getShortDescription() {
        return "[Draft]" + super.getShortDescription();
    }
}
