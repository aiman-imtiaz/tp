package seedu.duke.exceptions;

import seedu.duke.exceptions.HotelLiteManagerException;

/**
 * Represents an exception which would be thrown when the user enters an invalid format for the update item name
 * command.
 */
public class InvalidUpdateItemNameCommandException extends HotelLiteManagerException {
    private static final String ERROR_MESSAGE = "Error! Invalid Command -> Update Item Name OLD NAME / NEW NAME";

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }
}