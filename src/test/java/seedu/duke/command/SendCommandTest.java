package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.email.Email;
import seedu.duke.email.Sent;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SendCommandTest {
    @Test
    public void testSentConstructor() {
        // action
        String from = "senderEmail.com";
        ArrayList<String> to = new ArrayList<>();
        to.add("receiverEmail.com");
        String subject = "this is Subject";
        String time = "timeComposed";
        String content = "sample line 1" + "\n" + "sample line 2.";

        Email sentEmail = new Sent(from, to, subject, time, content, false);

        assertEquals(sentEmail.getFrom(), from);
        assertEquals(sentEmail.getTo(), to);
        assertEquals(sentEmail.getSubject(), subject);
        assertEquals(sentEmail.getTime(), time);
        assertEquals(sentEmail.getContent(), content);
    }
}