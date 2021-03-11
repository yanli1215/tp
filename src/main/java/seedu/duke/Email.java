package seedu.duke;

abstract class Email {
    protected String from;
    protected String to;
    protected String subject;
    protected String time;
    protected String content;

    public Email(String from, String to, String subject, String time, String content) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.time = time;
        this.content = content;
    }

}
