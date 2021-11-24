package en.mikula.adventure.items.terminals.cargoSpaceControl;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.base.game.GuiGame;
import en.mikula.adventure.gui.Map;
import en.mikula.adventure.items.terminals.Terminal;
import en.mikula.adventure.items.terminals.TerminalOption;
import en.mikula.adventure.rooms.CargoSpace;
import en.mikula.adventure.rooms.RoomCode;

/**
 * @author Marek Mikula
 * @version 17/5/21
 */
public class OpenCargoPlatformOption implements TerminalOption {

    private final Terminal terminal;
    private final Game game;

    public OpenCargoPlatformOption(Terminal terminal, Game game) {
        this.terminal = terminal;
        this.game = game;
    }

    public int getNumber() {
        return 2;
    }

    public String getText() {
        return "Open cargo platform";
    }

    public void handle() {
        CargoSpace cargoSpace = (CargoSpace) game.getMap().getRoom(RoomCode.ROOM_4);

        cargoSpace.setIsRampOpened(true);
        terminal.getHandler().output(terminal, "The ramp in the cargo space room has been opened!");

        // Check if aliens are still there, if so, remove them!
        if (cargoSpace.isAlienHere()) {
            cargoSpace.setIsAlienHere(false);
            terminal.getHandler().output(terminal, "The monsters in the cargo space should be now gone!");

            // Change map in the gui game so the aliens are not there
            if (game.getMode().equals(Game.MODE_GUI)) {
                ((GuiGame)game).getGui().getMap().setState(Map.STATE_WITHOUT_ALIENS);
            }
        }
    }

    @Override
    public Boolean shouldList() {
        return !((CargoSpace) game.getMap().getRoom(RoomCode.ROOM_4)).isRampOpened();
    }
}
