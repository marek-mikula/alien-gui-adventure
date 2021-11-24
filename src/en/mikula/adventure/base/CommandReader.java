package en.mikula.adventure.base;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.base.game.GuiGame;
import en.mikula.adventure.base.inputs.GuiInput;
import en.mikula.adventure.base.inputs.Input;
import en.mikula.adventure.base.inputs.UserInput;

/**
 * Reads command from given input
 * and passes it to command parser
 *
 * @author Marek Mikula
 * @version 4/6/2021
 */
public class CommandReader {

    private final Input input;

    private final CommandParser commandParser;

    public CommandReader(Game game) {
        commandParser = new CommandParser(game);

        if (game.getMode().equals(Game.MODE_GUI)) {
            input = new GuiInput((GuiGame) game);
        } else {
            input = new UserInput();
        }
    }

    /**
     * Reads one line from user and pass it to
     * command parser.
     *
     * @return parsed command
     */
    public String readCommand() {
        return commandParser.parseCommand(input.readLine());
    }

    /**
     * @return current input implementation
     */
    public Input getInput() {
        return input;
    }

    public CommandParser getCommandParser() {
        return commandParser;
    }

}
