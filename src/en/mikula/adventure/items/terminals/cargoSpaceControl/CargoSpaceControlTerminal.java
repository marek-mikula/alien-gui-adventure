package en.mikula.adventure.items.terminals.cargoSpaceControl;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.items.ItemCode;
import en.mikula.adventure.items.terminals.Terminal;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class CargoSpaceControlTerminal extends Terminal {

    public CargoSpaceControlTerminal(Game game) {
        super(game);
    }

    @Override
    public String getName() {
        return "Cargo space control terminal";
    }

    @Override
    public ItemCode getCode() {
        return ItemCode.ITEM_3;
    }

}
