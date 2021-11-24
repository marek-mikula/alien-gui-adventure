package en.mikula.adventure.utils;

import en.mikula.adventure.items.Item;

public class ItemUtils {

    public static String formatName(Item item) {
        return item.getName() + " [" + item.getCode().getNumber() + "]";
    }

}
