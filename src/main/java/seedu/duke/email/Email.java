package seedu.duke.email;

import java.util.ArrayList;
import java.util.Arrays;

public class Email {
    private String from;
    private ArrayList<String> to;
    private String subject;
    private String time;
    private String content;
    private boolean isRead;

    public Email(String from, ArrayList<String> to, String subject, String time, String content) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.time = time;
        this.content = content;
        this.isRead = false;
    }

    /**
     * Overloaded constructor, able to take in a single recipient and convert it
     * to a list of 1 recipient
     *
     * @param from    Person that sends the email
     * @param to      Person that receives the email
     * @param subject Topic of email
     * @param time    Time that email was sent
     * @param content Message in the email
     */
    public Email(String from, String to, String subject, String time, String content) {
        this(from, new ArrayList<>(), subject, time, content);
        ArrayList<String> toList = new ArrayList<>();
        toList.add(to);
        setTo(toList);
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public ArrayList<String> getTo() {
        return to;
    }

    public void setTo(ArrayList<String> to) {
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
