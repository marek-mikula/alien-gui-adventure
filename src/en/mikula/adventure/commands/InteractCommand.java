package en.mikula.adventure.commands;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.items.Interactive;
import en.mikula.adventure.items.Item;

/**
 * Interacts with an item in the room
 * f.i. terminals
 *
 * @author Marek Mikula
 * @version 4/6/2021
 * @see en.mikula.adventure.items.terminals.Terminal
 */
public class InteractCommand implements Command {

    private final Game game;

    public InteractCommand(Game game) {
        this.game = game;
    }

    @Override
    public String signature() {
        return "interact";
    }

    @Override
    public String fullSignature() {
        return signature() + " {itemNumber}";
    }

    @Override
    public String help() {
        return "Interacts with an item in the current room.";
    }

    @Override
    public String run(String... args) {
        if (args.length == 0) {
            return "You haven't specified the item number.";
        }

        Item item;

        // Try to parse the int in first argument and pass it to the method
        try {
            item = game.getMap().getCurrentRoom().getItem(Integer.parseInt(args[0]));
        } catch (NumberFormatException exception) {
            return "You have to enter the number of an item as a first argument.";
        }

        if (item == null) {
            return "There is no such item in the current room.";
        }

        if (!(item instanceof Interactive)) {
            return "You can't interact with this item.";
        }

        return ((Interactive) item).interact();
    }

}
