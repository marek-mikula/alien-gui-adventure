package en.mikula.adventure.items;

import en.mikula.adventure.utils.Observable;

import java.util.Objects;

/**
 * Common abstract class for all items
 *
 * @author Marek Mikula
 * @version 4/9/2021
 */
public abstract class Item extends Observable {

    /**
     * Gets the name of the item used for
     * item list etc.
     *
     * @return string name of an item
     */
    public abstract String getName();

    /**
     * Gets the code enum of an item
     *
     * @return item code enum
     */
    public abstract ItemCode getCode();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item room = (Item) o;
        return room.getCode().equals(getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode().getNumber());
    }

    /**
     * Resolves item image path but only if
     * the item is pickable
     * Non-pickable items don't have images because
     * they are not shown in the inventory
     *
     * @return image path as a string
     */
    public String getImagePath() {
        if (!(this instanceof Pickable)) {
            return null;
        }

        return ItemImageResolver.resolveImagePath(this);
    }

}
