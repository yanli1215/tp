package seedu.duke.command;

import com.sun.jdi.InvalidTypeException;
import seedu.duke.EmailManager;
import seedu.duke.Storage;
import seedu.duke.Ui;

public class SortCommand extends Command {
    private static final int STARTINDEXOFSORTTYPE = 5;

    public SortCommand(String s) {
        super(s);
    }

    public void execute(EmailManager emails, Ui ui, Storage storage) {

        try {
            String sortType = this.getUserInput().toLowerCase().substring(STARTINDEXOFSORTTYPE).trim();
            if (sortType.equalsIgnoreCase("sender")) {
                emails.sortBySender();
            } else if (sortType.equalsIgnoreCase("time")) {
                emails.sortByTime();
            } else {
                throw new InvalidTypeException();
            }
            ui.printEmailsSorted(sortType);
        } catch (InvalidTypeException e) {
            ui.showMessageForInvalidSortTypeInput();
        } catch (StringIndexOutOfBoundsException e) {
            ui.showMessageForEmptySortType(); //to chg to empty type
        }
    }

}
