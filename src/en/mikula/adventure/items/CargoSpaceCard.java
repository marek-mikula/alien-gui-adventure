package en.mikula.adventure.items;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.rooms.RoomCode;

/**
 * @author Marek Mikula
 * @version 4/10/2021
 */
public class CargoSpaceCard extends Item implements Key, Pickable {

    private final Game game;

    public CargoSpaceCard(Game game) {
        this.game = game;
    }

    @Override
    public String getName() {
        return "Cargo space card";
    }

    @Override
    public ItemCode getCode() {
        return ItemCode.ITEM_7;
    }

    @Override
    public String open(RoomCode roomCode) {
        if (!game.getMap().getCurrentRoom().getRoomCode().equals(RoomCode.ROOM_1)) {
            return "You can't open anything in this room with cargo space card.";
        }

        if (!roomCode.equals(RoomCode.ROOM_4)) {
            return "You can't open this room with this card!";
        }

        (game.getMap().getRoom(RoomCode.ROOM_1).getNext(RoomCode.ROOM_4.getNumber())).setIsLocked(false);

        return "You swiped the card trough the terminal next to the gate to cargo space. The gate opened!";
    }
}
