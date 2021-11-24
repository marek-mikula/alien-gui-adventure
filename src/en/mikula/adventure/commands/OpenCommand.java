package en.mikula.adventure.commands;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.items.Item;
import en.mikula.adventure.items.Key;
import en.mikula.adventure.rooms.RoomConnection;

/**
 * Opens the connection between rooms using
 * an item from the inventory
 *
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class OpenCommand implements Command {

    private final Game game;

    public OpenCommand(Game game) {
        this.game = game;
    }

    @Override
    public String signature() {
        return "open";
    }

    @Override
    public String fullSignature() {
        return signature() + " {roomNumber} {itemNumber}";
    }

    @Override
    public String help() {
        return "Opens the connection between rooms with an item from the inventory.";
    }

    @Override
    public String run(String... args) {
        if (args.length < 2) {
            return "You haven't specified an item code or a room code.";
        }

        Item item;
        RoomConnection next;

        // Try to parse the int in second argument and pass it to the method
        try {
            next = game.getMap().getCurrentRoom().getNext(Integer.parseInt(args[0]));
        } catch (NumberFormatException exception) {
            return "You have to enter the number of a room as a first argument.";
        }

        if (next == null) {
            return "The room you want to open does not exists or is not connected to current room.";
        }

        // Try to parse the int in first argument and pass it to the method
        try {
            item = game.getInventory().getItem(Integer.parseInt(args[1]));
        } catch (NumberFormatException exception) {
            return "You have to enter the number of an item as a second argument.";
        }

        if (item == null) {
            return "You don't have such item.";
        }

        if (!(item instanceof Key)) {
            return "You can't use this item as a key.";
        }

        return ((Key) item).open(next.getNext().getRoomCode());
    }

}
