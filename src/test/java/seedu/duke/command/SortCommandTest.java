package seedu.duke.command;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import seedu.duke.EmailManager;
import seedu.duke.Storage;
import seedu.duke.Ui;
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
    }

    

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
