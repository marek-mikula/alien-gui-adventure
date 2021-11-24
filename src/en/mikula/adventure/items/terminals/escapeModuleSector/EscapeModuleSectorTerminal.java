package en.mikula.adventure.items.terminals.escapeModuleSector;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.items.ItemCode;
import en.mikula.adventure.items.terminals.Terminal;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class EscapeModuleSectorTerminal extends Terminal {

    public EscapeModuleSectorTerminal(Game game) {
        super(game);
    }

    @Override
    public String getName() {
        return "Escape module sector terminal";
    }

    @Override
    public ItemCode getCode() {
        return ItemCode.ITEM_5;
    }

}
