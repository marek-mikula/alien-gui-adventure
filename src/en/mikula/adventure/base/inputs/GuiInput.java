package en.mikula.adventure.base.inputs;

import en.mikula.adventure.base.game.GuiGame;

public class GuiInput implements Input {

    private final GuiGame game;

    public GuiInput(GuiGame game) {
        this.game = game;
    }

    @Override
    public String readLine() {
        return game.getGui().getInput().readInput();
    }

}
