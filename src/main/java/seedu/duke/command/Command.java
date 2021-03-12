package seedu.duke.command;

import seedu.duke.EmailManager;
import seedu.duke.Storage;
import seedu.duke.Ui;
import seedu.duke.email.Email;

public abstract class Command {
    protected String userInput;

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public Command(String s) {
        userInput = s;
    }

    public void execute(EmailManager tasks, Ui ui, Storage storage) {

    }
}
