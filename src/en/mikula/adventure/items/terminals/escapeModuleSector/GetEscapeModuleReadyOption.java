package en.mikula.adventure.items.terminals.escapeModuleSector;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.items.EscapeModule;
import en.mikula.adventure.items.ItemCode;
import en.mikula.adventure.items.terminals.Terminal;
import en.mikula.adventure.items.terminals.TerminalOption;
import en.mikula.adventure.rooms.RoomCode;

/**
 * @author Marek Mikula
 * @version 17/5/21
 */
public class GetEscapeModuleReadyOption implements TerminalOption {

    private final Terminal terminal;
    private final Game game;

    public GetEscapeModuleReadyOption(Terminal terminal, Game game) {
        this.terminal = terminal;
        this.game = game;
    }

    @Override
    public int getNumber() {
        return 1;
    }

    @Override
    public String getText() {
        return "Prepare the escape module";
    }

    @Override
    public void handle() {
        ((EscapeModule) game.getMap().getRoom(RoomCode.ROOM_7).getItem(ItemCode.ITEM_6.getNumber())).setIsModuleReady(true);

        game.getTerminalHandler().output(terminal, "Module is ready to go!");
    }

    @Override
    public Boolean shouldList() {
        return !((EscapeModule) game.getMap().getRoom(RoomCode.ROOM_7).getItem(ItemCode.ITEM_6.getNumber())).isModuleReady();
    }
}
