package en.mikula.adventure.base;

import en.mikula.adventure.commands.Command;

import java.util.HashMap;
import java.util.Map;

/**
 * The list of available commands
 *
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class CommandList {

    private final Map<String, Command> commands = new HashMap<>();

    /**
     * Adds new command to the list
     *
     * @param command instance to be added to the list
     */
    public Command addCommand(Command command) {
        return commands.put(command.signature(), command);
    }

    /**
     * Checks if a string signature key exists in the map
     *
     * @param signature the string signature of the command
     * @return true if exists, otherwise false
     */
    public boolean isValidCommand(String signature) {
        return commands.containsKey(signature);
    }

    /**
     * Gets the command by given signature if in the list
     *
     * @param signature the string signature of the command
     * @return command instance or null
     */
    public Command getCommand(String signature) {
        return commands.getOrDefault(signature, null);
    }

    /**
     * Gets the list of commands
     *
     * @return list of commands
     */
    public Map<String, Command> getCommands() {
        return commands;
    }

}
