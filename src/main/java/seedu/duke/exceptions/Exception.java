package seedu.duke.exceptions;

import seedu.duke.Ui;

public abstract class Exception {
    private String commandType;

    public Exception(String commandType) {
        this.commandType = commandType;
    }

    public String getCommandType() {
        return commandType;
    }

    public void setCommandType(String commandType) {
        this.commandType = commandType;
    }

    public void showErrorMessage(Ui ui) {

    }
}
