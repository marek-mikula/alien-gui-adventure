package en.mikula.adventure.commands;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.base.game.GuiGame;

/**
 * Clears the console output in GUI mode
 *
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class ClearCommand implements Command {

    private final Game game;

    public ClearCommand(Game game) {
        this.game = game;
    }

    @Override
    public String signature() {
        return "clear";
    }

    @Override
    public String fullSignature() {
        return signature();
    }

    @Override
    public String help() {
        return "Clears the GUI console output.";
    }

    @Override
    public String run(String... args) {
        ((GuiGame) game).getGui().getOutput().clear();
        return "Console was cleared!";
    }

}
