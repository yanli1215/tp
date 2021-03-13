package seedu.duke.email;

public class Email {
    private String from;
    private String to;
    private String subject;
    private String time;
    private String content;
    private boolean isRead;

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public Email(String from, String to, String subject, String time, String content) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.time = time;
        this.content = content;
        this.isRead = false;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String getStatus() {
        return isRead ? "READ" : "UNREAD";
    }

    public String toString() {
        return getShortDescription() + "\n|| Content: " + getContent();
    }

    public String getShortDescription() {
        return "[" + getStatus() + "]" + "\n|| Subject: " + getSubject() + "\n|| From: " + getFrom() + " --> To: "
                + getTo();
    }
}
