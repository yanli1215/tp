package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.email.Draft;
import seedu.duke.email.Email;

import static org.junit.jupiter.api.Assertions.*;

class ComposeCommandTest {
    @Test
    public void testComposeConstructor() {
        // action
        String from = "senderEmail.com";
        String to = "receiverEmail.com";
        String subject = "this is Subject";
        String time = "timeComposed";
        String content = "sample line 1" + "\n" + "sample line 2.";

        Email draftEmail = new Draft(from, to, subject, time, content);

        assertEquals(draftEmail.getFrom(), from);
        assertEquals(draftEmail.getTo(), to);
        assertEquals(draftEmail.getSubject(), subject);
        assertEquals(draftEmail.getTime(), time);
        assertEquals(draftEmail.getContent(), content);
    }

    @Test
    public void testError() {

    }

}