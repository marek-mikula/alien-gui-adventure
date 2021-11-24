package en.mikula.adventure.commands;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.items.Item;

import java.util.HashSet;

/**
 * Searches the current room showing all
 * available items
 *
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class SearchCommand implements Command {

    private final Game game;

    public SearchCommand(Game game) {
        this.game = game;
    }

    @Override
    public String signature() {
        return "search";
    }

    @Override
    public String fullSignature() {
        return signature();
    }

    @Override
    public String help() {
        return "Searches the current room and shows list of available items.";
    }

    @Override
    public String run(String... args) {
        HashSet<Item> items = game.getMap().getCurrentRoom().getItems();

        if (items.isEmpty()) {
            return "There are not items in the current room.";
        }

        StringBuilder itemList = new StringBuilder("Available items:");

        for (Item item : items) {
            itemList.append("\n").append("[").append(item.getCode().getNumber()).append("] ").append(item.getName());
        }

        return itemList.toString();
    }

}
