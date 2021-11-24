package en.mikula.adventure.items.terminals;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.items.Interactive;
import en.mikula.adventure.items.Item;
import en.mikula.adventure.items.terminals.exceptions.TerminalInputException;
import en.mikula.adventure.items.terminals.handler.TerminalHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Abstract class for all terminals, so they
 * all share common functionality which is
 * showing options, reading user input and so on
 *
 * @author Marek Mikula
 * @version 4/9/2021
 */
public abstract class Terminal extends Item implements Interactive {

    private final Map<Integer, TerminalOption> options = new HashMap<>();

    private final Game game;

    /**
     * Specifies if the terminal is being used
     */
    private boolean active = false;

    public Terminal(Game game) {
        this.game = game;

        // Put close option by default into map
        this.addOption(new CloseTerminalOption(this));
    }

    @Override
    public String interact() {
        // Pass this instance of terminal to current
        // handler instance
        game.getTerminalHandler().handle(this);

        // Return closing text back to main game
        return "You closed the terminal.";
    }

    /**
     * Adds one option to the map
     *
     * @param option to be added
     */
    public void addOption(TerminalOption option) {
        options.put(option.getNumber(), option);
    }

    /**
     * @return map of added options
     */
    public Map<Integer, TerminalOption> getOptions() {
        return options;
    }

    /**
     * Returns terminal option by given number
     *
     * @return terminal option if exists, null otherwise
     */
    public TerminalOption getOptionByNumber(int number) {
        return options.get(number);
    }

    /**
     * Sets the terminal active state
     */
    public void setIsActive(boolean isActive) {
        active = isActive;
    }

    /**
     * @return terminal active state
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @return terminal handler implementation
     * from game
     */
    public TerminalHandler getHandler() {
        return game.getTerminalHandler();
    }

    public void handleInput(String input) throws TerminalInputException {
        if (input.isEmpty()) {
            throw new TerminalInputException("You did not enter any option!");
        }

        // Try to convert given text to number

        int optionNumber;
        try {
            optionNumber = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new TerminalInputException("You entered invalid option number.");
        }

        TerminalOption terminalOption = getOptionByNumber(optionNumber);

        if (terminalOption == null || !terminalOption.shouldList()) {
            throw new TerminalInputException("This option does not exist!");
        }

        terminalOption.handle();

        // Notify observers
        notifyObservers();
    }

}
