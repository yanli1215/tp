package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.email.Email;
import seedu.duke.email.Sent;

import static org.junit.jupiter.api.Assertions.*;

class SendCommandTest {
    @Test
    public void testSentConstructor() {
        // action
        String from = "senderEmail.com";
        String to = "receiverEmail.com";
        String subject = "this is Subject";
        String time = "timeComposed";
        String content = "sample line 1" + "\n" + "sample line 2.";

        Email sentEmail = new Sent(from, to, subject, time, content);

        assertEquals(sentEmail.getFrom(), from);
        assertEquals(sentEmail.getTo(), to);
        assertEquals(sentEmail.getSubject(), subject);
        assertEquals(sentEmail.getTime(), time);
        assertEquals(sentEmail.getContent(), content);
    }
}