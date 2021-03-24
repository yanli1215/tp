package seedu.duke.command;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.EmailManager;
import seedu.duke.Storage;
import seedu.duke.Ui;
import seedu.duke.email.Email;
import seedu.duke.email.Inbox;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class ReadCommandTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private ArrayList<Email> emails = new ArrayList<>();
    private EmailManager emailManager = new EmailManager();
    private Ui ui = new Ui();
    private Storage storage = new Storage();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        emails.add(new Inbox("123@gmail.com", "456@gmail.com", "S1", "2012-01-01", "C1"));
        emails.add(new Inbox("123@gmail.com", "456@gmail.com", "S2", "2012-01-02", "C2"));
        emailManager.setListedEmailsList(emails);

    }

    @Test
    void execute_validIndex_success() {
        new ReadCommand("read 1").execute(emailManager, ui, storage);

        Assertions.assertEquals("[Inbox][READ]\n"
                        + "|| Subject: S1\n"
                        + "|| From: 123@gmail.com --> To: [456@gmail.com]\n"
                        + "|| Content: C1",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void execute_invalidIndex_message() {
        new ReadCommand("read -1").execute(emailManager, ui, storage);

        Assertions.assertEquals("OOPS!!! The Email ID that you READ is invalid.",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void execute_nullList_message() {
        emailManager.setListedEmailsList(null);
        new ReadCommand("read 1").execute(emailManager, ui, storage);

        Assertions.assertEquals("You have to list emails first" + System.lineSeparator()
                        + "=> list emails" + System.lineSeparator()
                        + "____________________________________________________________",
                outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
