package en.mikula.adventure.items.terminals.cargoSpaceControl;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.items.terminals.Terminal;
import en.mikula.adventure.items.terminals.TerminalOption;
import en.mikula.adventure.rooms.CargoSpace;
import en.mikula.adventure.rooms.RoomCode;

/**
 * @author Marek Mikula
 * @version 17/5/21
 */
public class CloseCargoPlatformOption implements TerminalOption {

    private final Terminal terminal;
    private final Game game;

    public CloseCargoPlatformOption(Terminal terminal, Game game) {
        this.terminal = terminal;
        this.game = game;
    }

    public int getNumber() {
        return 1;
    }

    public String getText() {
        return "Close cargo platform";
    }

    public void handle() {
        ((CargoSpace) game.getMap().getRoom(RoomCode.ROOM_4)).setIsRampOpened(false);

        terminal.getHandler().output(terminal, "The ramp in the cargo space room has been closed!");
    }

    @Override
    public Boolean shouldList() {
        return ((CargoSpace) game.getMap().getRoom(RoomCode.ROOM_4)).isRampOpened();
    }
}
