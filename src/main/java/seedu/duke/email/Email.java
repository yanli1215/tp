package seedu.duke.email;

import seedu.duke.exceptions.InvalidIndexException;

import java.util.ArrayList;
import java.util.Arrays;

public class Email {
    private String from;
    private ArrayList<String> to;
    private String subject;
    private String time;
    private String content;
    private boolean isRead;
    private ArrayList<String> tags;

    private static final String[] availableTags = {"Important", "Family", "Friends", "School", "Work", "Travels"};

    public Email(String from, ArrayList<String> to, String subject, String time, String content, boolean isRead) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.time = time;
        this.content = content;
        this.isRead = isRead;
        this.tags = new ArrayList<>();
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
                + getTo() + "\n|| Time: " + getTime() + "\n|| Tags: " + tags.toString();
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public static String[] getAvailableTags() {
        return availableTags;
    }

    public ArrayList<String> setTags(int[] indices) throws InvalidIndexException {
        tags = new ArrayList<>();
        try {
            for (int i = 0; i < indices.length; i++) {
                tags.add(availableTags[indices[i] - 1]);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidIndexException();
        }

        return tags;
    }

    private static ArrayList<String> stringToList(String to) {
        return new ArrayList<String>(Arrays.asList(new String[]{to}));
    }
}
