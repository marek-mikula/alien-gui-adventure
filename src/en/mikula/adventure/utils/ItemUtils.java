package en.mikula.adventure.utils;

import en.mikula.adventure.items.Item;

public class ItemUtils {

    /**
     * Formats name for an item
     */
    public static String formatName(Item item) {
        return item.getName() + " [" + item.getCode().getNumber() + "]";
    }

}
