package en.mikula.adventure.items.terminals.cargoSpace;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.gui.terminal.CodeInput;
import en.mikula.adventure.gui.terminal.CodeInputCallback;
import en.mikula.adventure.items.Diary;
import en.mikula.adventure.items.terminals.Terminal;
import en.mikula.adventure.items.terminals.TerminalOption;
import en.mikula.adventure.rooms.RoomCode;

/**
 * @author Marek Mikula
 * @version 17/5/21
 */
public class EnterCodeToStorageRoomOption implements TerminalOption {

    private final Terminal terminal;
    private final Game game;

    public EnterCodeToStorageRoomOption(Terminal terminal, Game game) {
        this.terminal = terminal;
        this.game = game;
    }

    public int getNumber() {
        return 5;
    }

    public String getText() {
        return "Enter password to storage room";
    }

    public void handle() {
        terminal.getHandler().output(terminal, "Enter the password:");

        if (game.getMode().equals(Game.MODE_GUI)) {
            handleGui();
        } else {
            handleText();
        }
    }

    private void handleGui() {
        // Callback for a code window
        CodeInputCallback callback = new CodeInputCallback() {
            @Override
            public void onSuccess() {
                terminal.getHandler().output(terminal, "Password was correct! The door to storage room has opened!");
                (game.getMap().getRoom(RoomCode.ROOM_4).getNext(RoomCode.ROOM_5.getNumber())).setIsLocked(false);
            }

            @Override
            public void onFail() {
                terminal.getHandler().output(terminal, "The password is incorrect.");
            }

            @Override
            public void onClose() {
                terminal.getHandler().output(terminal, "No password entered.");
            }
        };

        CodeInput.enterCode(Diary.STORAGE_CODE, callback);
    }

    private void handleText() {
        String line = game.getInput().readLine();
        if (line != null && line.equals(Diary.STORAGE_CODE)) {
            System.out.println("Password was correct! The door to storage room has opened!");
            (game.getMap().getRoom(RoomCode.ROOM_4).getNext(RoomCode.ROOM_5.getNumber())).setIsLocked(false);
        } else {
            System.out.println("The password is incorrect.");
        }
    }

    @Override
    public Boolean shouldList() {
        return (game.getMap().getRoom(RoomCode.ROOM_4).getNext(RoomCode.ROOM_5.getNumber())).isLocked();
    }
}
