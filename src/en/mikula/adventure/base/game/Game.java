package en.mikula.adventure.base.game;

import en.mikula.adventure.base.CommandReader;
import en.mikula.adventure.base.Inventory;
import en.mikula.adventure.base.Map;
import en.mikula.adventure.base.inputs.Input;
import en.mikula.adventure.factories.MapFactory;
import en.mikula.adventure.items.terminals.handler.TerminalHandler;
import en.mikula.adventure.items.terminals.handler.TerminalHandlerFactory;

/**
 * Main game class which handles the main
 * while loop
 *
 * @author Marek Mikula
 * @version 4/6/2021
 */
abstract public class Game {

    public static final String GAME_NAME = "Alien Console Adventure";

    public static final String MODE_TEXT = "text";
    public static final String MODE_GUI = "gui";

    protected final TerminalHandler terminalHandler;
    protected final CommandReader commandReader;
    protected final Inventory inventory;
    protected final Map map;

    protected boolean hasEnded = false;

    public Game() {
        terminalHandler = TerminalHandlerFactory.build(this);
        commandReader = new CommandReader(this);
        map = MapFactory.buildMap(this);
        inventory = new Inventory();
    }

    /**
     * Main method which handles the main
     * while loop, reads commands and
     * interacts with gui/console
     */
    public abstract void start();

    /**
     * @return the mode of the current game implementation
     */
    public abstract String getMode();

    /**
     * Sets the state if game ended
     *
     * @param hasEnded state
     */
    public void setHasEnded(boolean hasEnded) {
        this.hasEnded = hasEnded;
    }

    /**
     * @return map
     */
    public Map getMap() {
        return map;
    }

    /**
     * @return inventory implementation
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * @return terminal handler implementation
     */
    public TerminalHandler getTerminalHandler() {
        return terminalHandler;
    }

    /**
     * Allows other components to use input reader
     *
     * @return current input implementation
     */
    public Input getInput() {
        return commandReader.getInput();
    }

    /**
     * @return command reader instance
     */
    public CommandReader getCommandReader() {
        return commandReader;
    }

}
