package seedu.duke;

/**
 * Represents an Update Item Pax Command. An Update Item Pax Command object consists of the name of the item to update
 * and the new pax value.
 */
public class UpdateItemPaxCommand extends Command {
    private Item item;
    private final String ITEM_NAME_INDICATOR = "/Name:";
    private final int ITEM_NAME_INDICATOR_LENGTH = 6;
    private final String ITEM_PAX_INDICATOR = "/New Pax:";
    private final int ITEM_PAX_INDICATOR_LENGTH = 9;

    /**
     * Takes in the user input and checks if the formatting of the Update Item Pax Command within the user input is
     * valid.
     * Extracts out the item name and item pax from the user input and creates an UpdateItemPaxCommand object.
     *
     * @param userInput The user's input.
     * @throws HotelLiteManagerException if either the formatting of the update item pax command is invalid or if the
     *                                   item pax, name is empty or invalid.
     */
    public UpdateItemPaxCommand(String userInput) throws HotelLiteManagerException {
        Item item;
        int itemPax;
        String itemName;
        boolean isValidUpdateItemCommand = userInput.contains(ITEM_NAME_INDICATOR)
                && userInput.contains(ITEM_PAX_INDICATOR);
        if (!isValidUpdateItemCommand) {
            throw new InvalidCommandException();
        }
        itemPax = extractItemPax(userInput);
        itemName = extractItemName(userInput);
        item = new Item(itemName, itemPax);
        setItem(item);
    }

    /**
     * Returns the item name extracted from the user input.
     *
     * @param userInput The user's input.
     * @return The item name within the user input.
     * @throws HotelLiteManagerException if item name is empty.
     */
    private String extractItemName(String userInput) throws HotelLiteManagerException {
        String itemName;
        int itemNameStartingPosition = userInput.indexOf(ITEM_NAME_INDICATOR) + ITEM_NAME_INDICATOR_LENGTH;
        int itemPaxIndicatorPosition = userInput.indexOf(ITEM_PAX_INDICATOR);
        itemName = userInput.substring(itemNameStartingPosition, itemPaxIndicatorPosition);
        itemName = itemName.trim();
        if (itemName.isEmpty()) {
            throw new EmptyItemNameException();
        }
        return itemName;
    }

    /**
     * Returns the item pax extracted from the user input.
     *
     * @param userInput The user's input.
     * @return The item pax within the user input.
     * @throws HotelLiteManagerException if item pax is empty or invalid.
     */
    private int extractItemPax(String userInput) throws HotelLiteManagerException {
        int itemPax;
        String itemPaxStringVersion;
        int stringEndingPosition = userInput.length();
        int itemPaxStartingPosition = userInput.indexOf(ITEM_PAX_INDICATOR) + ITEM_PAX_INDICATOR_LENGTH;
        if (itemPaxStartingPosition == stringEndingPosition) {
            throw new EmptyItemPaxException();
        }
        itemPaxStringVersion = userInput.substring(itemPaxStartingPosition);
        try {
            itemPax = Integer.parseInt(itemPaxStringVersion);
        } catch (NumberFormatException e) {
            throw new InvalidItemPaxException();
        }
        if (itemPax < 0) {
            throw new InvalidItemPaxException();
        }
        return itemPax;
    }

    @Override
    public void execute(HousekeeperList housekeeperList, SatisfactionList satisfactionList, RoomList roomList,
                        ItemList listOfItems, Ui ui) throws HotelLiteManagerException {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
