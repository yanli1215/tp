package seedu.duke.email;

public class Archive extends Email {
    public Archive(String from, String to, String subject, String time, String content) {
        super(from, to, subject, time, content);
    }

    @Override
    public String toString() {
        return "[Archive]" + super.toString();
    }
}
