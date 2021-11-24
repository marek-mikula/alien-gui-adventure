package en.mikula.adventure.base;

import en.mikula.adventure.items.Item;
import en.mikula.adventure.utils.Observable;

import java.util.HashSet;
import java.util.Set;

/**
 * User's inventory list
 *
 * @author Marek Mikula
 * @version 4/10/2021
 */
public class Inventory extends Observable {

    /**
     * List of items that user carries
     */
    private final Set<Item> items = new HashSet<>();

    /**
     * Adds new item to inventory and notifies
     * observers
     *
     * @param item to be added
     * @return boolean if successfully added
     */
    public boolean addItem(Item item) {
        boolean status = items.add(item);;

        notifyObservers();

        return status;
    }

    /**
     * Removes item from inventory and notifies
     * observers
     *
     * @param item to be removed
     * @return boolean if successfully removed
     */
    public boolean removeItem(Item item) {
        boolean status = items.remove(item);

        notifyObservers();

        return status;
    }

    /**
     * Gets the list of items that
     * user carries
     *
     * @return list of items
     */
    public Set<Item> getItems() {
        return items;
    }

    /**
     * Gets the item by given item code
     *
     * @param itemCode integer item code
     * @return found item or null
     */
    public Item getItem(int itemCode) {
        for (Item item : items) {
            if (item.getCode().getNumber() == itemCode) {
                return item;
            }
        }

        return null;
    }

}
