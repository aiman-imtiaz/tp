package seedu.duke.command.housekeepercommands;

import java.util.ArrayList;

import seedu.duke.Housekeeper;
import seedu.duke.HousekeeperList;
import seedu.duke.ListContainer;
import seedu.duke.Ui;
import seedu.duke.HotelLiteManagerException;
import seedu.duke.command.Command;
import seedu.duke.InvalidNewYearException;

public class AgeIncreaseCommand extends Command {
    private static final String UPDATE_AGE_BY_ONE = "is a new year";

    public AgeIncreaseCommand(String input) throws HotelLiteManagerException {
        if (!input.equals(UPDATE_AGE_BY_ONE)) {
            throw new InvalidNewYearException();
        }
    }

    /**
     * Increases all housekeeper's age by one and records housekeeper who has exceed age limit. Housekeeper who exceed
     * age limit will be removed from the list.
     *
     * @param listContainer The list of information.
     * @param ui            The instance of the Ui class used for printing additional messages when a command is executed.
     */
    @Override
    public void execute(ListContainer listContainer, Ui ui) {
        HousekeeperList housekeeperList = listContainer.getHousekeeperList();
        housekeeperList.increaseAllAgeByOne();
        ui.printMessage("Everyone age has increased by one");
        ArrayList<Housekeeper> overAgeHousekeeperList = housekeeperList.getHousekeeperExceedValidAgeList();
        ui.printMessage("**Over age limit housekeeper will be removed from list**");
        ui.printOverAgeList(overAgeHousekeeperList);
        housekeeperList.deleteOverAgeHousekeeper();
    }
}
