package seedu.duke.exceptions;

import seedu.duke.exceptions.HotelLiteManagerException;

public class InvalidEventException extends HotelLiteManagerException {
    private static final String ERROR_MESSAGE = "Error! Please add event with format: event DESCRIPTION / DATE"
            + "the date should be in format yyyy-mm-dd.";

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }
}