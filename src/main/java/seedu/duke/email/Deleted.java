package seedu.duke.email;

public class Deleted extends Email {
    public Deleted(String from, String to, String subject, String time, String content) {
        super(from, to, subject, time, content);
    }

    @Override
    public String getShortDescription() {
        return "[Deleted]" + super.getShortDescription();
    }

}
