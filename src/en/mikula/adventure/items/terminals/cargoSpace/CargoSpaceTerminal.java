package en.mikula.adventure.items.terminals.cargoSpace;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.items.ItemCode;
import en.mikula.adventure.items.terminals.Terminal;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class CargoSpaceTerminal extends Terminal {

    public CargoSpaceTerminal(Game game) {
        super(game);
    }

    @Override
    public String getName() {
        return "Cargo space terminal";
    }

    @Override
    public ItemCode getCode() {
        return ItemCode.ITEM_8;
    }

}
