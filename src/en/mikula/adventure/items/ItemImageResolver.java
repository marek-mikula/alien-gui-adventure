package en.mikula.adventure.items;

import en.mikula.adventure.utils.CaseTransformer;

public class ItemImageResolver {

    /**
     * Resolves an image name for a given item
     */
    public static String resolveImagePath(Item item) {
        return "resources/items/" + CaseTransformer.camelToSnake(item.getClass().getSimpleName()) + ".png";
    }

}
