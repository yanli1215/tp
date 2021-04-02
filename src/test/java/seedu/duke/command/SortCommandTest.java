package seedu.duke.command;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.email.Deleted;
import seedu.duke.email.EmailManager;
import seedu.duke.email.Inbox;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;
import seedu.duke.email.Email;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class SortCommandTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private ArrayList<Email> emails = new ArrayList<>();
    private EmailManager emailManager = new EmailManager();
    private Ui ui = new Ui();
    private Storage storage = new Storage();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        emails.add(new Inbox("testC@gmail.com", "456@gmail.com", "S1", "2020-4-23+01:00", "C1"));
        emails.add(new Inbox("testA@gmail.com", "456@gmail.com", "S2", "2020-4-30+01:00", "C2"));
        emails.add(new Deleted("testB@gmail.com", "456@gmail.com", "S3", "2019-4-23+03:00", "C3"));
        EmailManager.setEmailsList(emails);
    }

    @Test
    void execute_SortTime_success() {
        new SortCommand("sort time").execute(emailManager, ui, storage);
        String expectedOutput = "Emails are sorted according to time";
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void execute_SortSender_success() {
        new SortCommand("sort sender").execute(emailManager, ui, storage);
        String expectedOutput = "Emails are sorted according to sender";
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void execute_InvalidType_fail() {
        new SortCommand("sort sendy").execute(emailManager, ui, storage);
        String expectedOutput = "OOPS!!! The type that you enter is invalid." + System.lineSeparator()
                + "It must be one of: [sender, time]";
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void execute_EmptyType_fail() {
        new SortCommand("sort  ").execute(emailManager, ui, storage);
        String expectedOutput = "OOPS!!! The sort type is empty." + System.lineSeparator()
                + "Please enter one of: [sender, time] after \"sort\".";
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString()
                .trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
