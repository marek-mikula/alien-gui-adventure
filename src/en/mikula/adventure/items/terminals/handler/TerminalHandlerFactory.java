package en.mikula.adventure.items.terminals.handler;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.base.game.GuiGame;

public class TerminalHandlerFactory {

    public static TerminalHandler build(Game game) {
        if (game.getMode().equals(Game.MODE_GUI)) {
            return new GuiTerminalHandler((GuiGame) game);
        }

        return new TextTerminalHandler(game);
    }

}
