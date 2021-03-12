package seedu.duke.email;

public class Draft extends Email {
    public Draft(String from, String to, String subject, String time, String content) {
        super(from, to, subject, time, content);
    }

    @Override
    public String toString() {
        return "[Draft]" + super.toString();
    }
}
