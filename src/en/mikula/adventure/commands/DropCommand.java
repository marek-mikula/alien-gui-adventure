package en.mikula.adventure.commands;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.items.Item;

/**
 * Drops an item by its number
 *
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class DropCommand implements Command {

    private final Game game;

    public DropCommand(Game game) {
        this.game = game;
    }

    @Override
    public String signature() {
        return "drop";
    }

    @Override
    public String fullSignature() {
        return signature() + " {itemNumber}";
    }

    @Override
    public String help() {
        return "Drops an item. Use an item number as a first argument.";
    }

    @Override
    public String run(String... args) {
        if (args.length == 0) {
            return "You haven't specified the item number.";
        }

        Item item;

        // Try to parse the int in first argument and pass it to the method
        try {
            item = game.getInventory().getItem(Integer.parseInt(args[0]));
        } catch (NumberFormatException exception) {
            return "You have to enter the number of an item as a first argument.";
        }

        if (item == null) {
            return "There is no such item in your inventory.";
        }

        // Drop the item to the current room
        game.getMap().getCurrentRoom().addItem(item);

        // Remove the item from the inventory
        game.getInventory().removeItem(item);

        return "You dropped the item [" + item.getName() + "].";
    }

}
