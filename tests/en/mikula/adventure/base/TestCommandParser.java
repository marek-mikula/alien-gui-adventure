package en.mikula.adventure.base;

import en.mikula.adventure.base.game.TextGame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * @author Marek Mikula
 * @version 4/24/2021
 */
public class TestCommandParser {

    private CommandParser commandParser;

    @Before
    public void setup() {
        TextGame game = new TextGame();
        commandParser = new CommandParser(game);
    }

    @Test
    public void tryParseCommand() {
        // First try valid command
        try {
            commandParser.parseCommand("go 1");
        } catch (RuntimeException exception) {
            fail();
        }

        // Now try invalid command
        try {
            commandParser.parseCommand("invalid command");
        } catch (RuntimeException exception) {
            return;
        }

        fail();
    }

}
