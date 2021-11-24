package en.mikula.adventure.items;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.rooms.RoomCode;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class Screwdriver extends Item implements Pickable, Key {

    private final Game game;

    public Screwdriver(Game game) {
        this.game = game;
    }

    @Override
    public String getName() {
        return "Screwdriver";
    }

    @Override
    public ItemCode getCode() {
        return ItemCode.ITEM_4;
    }

    @Override
    public String open(RoomCode roomCode) {
        if (!game.getMap().getCurrentRoom().getRoomCode().equals(RoomCode.ROOM_5)) {
            return "You can't open anything in this room with this screwdriver.";
        }

        if (!roomCode.equals(RoomCode.ROOM_6)) {
            return "You can't open this room with this card!";
        }

        (game.getMap().getRoom(RoomCode.ROOM_5).getNext(RoomCode.ROOM_6.getNumber())).setIsLocked(false);

        return "You used the screwdriver to remove the screws from a cover of the ventilation. The path is opened!";
    }

}
