package seedu.duke.command;

import seedu.duke.EmailManager;
import seedu.duke.Storage;
import seedu.duke.Ui;
import seedu.duke.email.Email;

public abstract class Command<T> {
    protected T argument;

    public Command(T s) {
        argument = s;
    }
    public Command() {
        argument = null;
    }

    public T getUserInput() {
        return argument;
    }

    public void setUserInput(T userInput) {
        this.argument = userInput;
    }

    public void execute(EmailManager tasks, Ui ui, Storage storage) {

    }
}
