package seedu.duke.exceptions;

import seedu.duke.Ui;

public class InvalidIndexException extends Exception{
    public InvalidIndexException(String commandType) {
        super(commandType);
    }

    @Override
    public void showErrorMessage(Ui ui) {
        ui.showInvalidIDMessage();
    }
}
