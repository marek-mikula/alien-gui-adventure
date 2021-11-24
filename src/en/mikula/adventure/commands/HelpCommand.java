package en.mikula.adventure.commands;

import en.mikula.adventure.base.CommandList;

/**
 * Shows all available commands with their full
 * signature and help text
 *
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class HelpCommand implements Command {

    private final CommandList commandList;

    public HelpCommand(CommandList commandList) {
        this.commandList = commandList;
    }

    @Override
    public String signature() {
        return "help";
    }

    @Override
    public String fullSignature() {
        return signature();
    }

    @Override
    public String help() {
        return "Shows list of possible commands.";
    }

    @Override
    public String run(String... args) {
        StringBuilder response = new StringBuilder("Available commands:");

        for (Command command : commandList.getCommands().values()) {
            response.append("\n").append("[").append(command.fullSignature()).append("] - ").append(command.help());
        }

        return response.toString();
    }

}
