package en.mikula.adventure.items.terminals.bridge;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.items.ItemCode;
import en.mikula.adventure.items.terminals.Terminal;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class BridgeTerminal extends Terminal {

    public BridgeTerminal(Game game) {
        super(game);
    }

    @Override
    public String getName() {
        return "Main bridge terminal";
    }

    @Override
    public ItemCode getCode() {
        return ItemCode.ITEM_1;
    }
}
