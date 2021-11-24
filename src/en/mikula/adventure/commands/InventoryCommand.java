package en.mikula.adventure.commands;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.items.Item;

import java.util.Set;

/**
 * Lists all items in the inventory
 *
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class InventoryCommand implements Command {

    private final Game game;

    public InventoryCommand(Game game) {
        this.game = game;
    }

    @Override
    public String signature() {
        return "inventory";
    }

    @Override
    public String fullSignature() {
        return signature();
    }

    @Override
    public String help() {
        return "Lists all items in the inventory.";
    }

    @Override
    public String run(String... args) {
        Set<Item> items = game.getInventory().getItems();

        if (items.isEmpty()) {
            return "You don't have any items in the inventory.";
        }

        StringBuilder itemList = new StringBuilder("Inventory:");

        for (Item item : items) {
            itemList.append("\n").append("[").append(item.getCode().getNumber()).append("] ").append(item.getName());
        }

        return itemList.toString();
    }

}
