package en.mikula.adventure.base;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.base.game.TextGame;
import en.mikula.adventure.commands.Command;
import en.mikula.adventure.commands.DropCommand;
import en.mikula.adventure.commands.GoCommand;
import en.mikula.adventure.commands.InteractCommand;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Marek Mikula
 * @version 4/23/2021
 */
public class TestCommandList {

    private CommandList commandList;

    private Game game;

    @Before
    public void setup() {
        commandList = new CommandList();
        game = new TextGame();
    }

    @Test
    public void testAddCommand() {
        DropCommand dropCommand = new DropCommand(game);
        GoCommand goCommand = new GoCommand(game);

        assertNull(commandList.addCommand(dropCommand));
        assertNull(commandList.addCommand(goCommand));
        assertEquals(goCommand, commandList.addCommand(goCommand));
    }

    @Test
    public void testIsValidCommand() {
        DropCommand dropCommand = new DropCommand(game);
        GoCommand goCommand = new GoCommand(game);
        InteractCommand interactCommand = new InteractCommand(game);

        assertNull(commandList.addCommand(dropCommand));
        assertNull(commandList.addCommand(goCommand));

        assertTrue(commandList.isValidCommand(dropCommand.signature()));
        assertTrue(commandList.isValidCommand(goCommand.signature()));
        assertFalse(commandList.isValidCommand(interactCommand.signature()));
    }

    @Test
    public void testGetCommand() {
        DropCommand dropCommand = new DropCommand(game);
        GoCommand goCommand = new GoCommand(game);
        InteractCommand interactCommand = new InteractCommand(game);

        assertNull(commandList.addCommand(dropCommand));
        assertNull(commandList.addCommand(goCommand));

        assertEquals(dropCommand, commandList.getCommand(dropCommand.signature()));
        assertEquals(goCommand, commandList.getCommand(goCommand.signature()));
        assertNull(commandList.getCommand(interactCommand.signature()));
    }

    @Test
    public void testGetCommands() {
        DropCommand dropCommand = new DropCommand(game);
        GoCommand goCommand = new GoCommand(game);
        InteractCommand interactCommand = new InteractCommand(game);

        Map<String, Command> commandMap = new HashMap<>();

        assertNull(commandList.addCommand(dropCommand));
        assertNull(commandList.addCommand(goCommand));
        assertNull(commandList.addCommand(interactCommand));

        commandMap.put(dropCommand.signature(), dropCommand);
        commandMap.put(goCommand.signature(), goCommand);
        commandMap.put(interactCommand.signature(), interactCommand);

        assertEquals(commandMap, commandList.getCommands());
    }

}
