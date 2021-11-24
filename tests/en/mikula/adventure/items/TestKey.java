package en.mikula.adventure.items;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.base.game.TextGame;
import en.mikula.adventure.rooms.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Marek Mikula
 * @version 4/24/2021
 */
public class TestKey {

    private Game game;

    @Before
    public void setup() {
        game = new TextGame();
    }

    @Test
    public void testItemCanOpen() {
        game.getMap().changeCurrentRoom(game.getMap().getRoom(RoomCode.ROOM_1), true);

        CargoSpaceCard cargoSpaceCard = new CargoSpaceCard(game);

        RoomConnection roomConnection = game.getMap().getRoom(RoomCode.ROOM_1).getNext(RoomCode.ROOM_4.getNumber());

        assertTrue(roomConnection.isLocked());

        cargoSpaceCard.open(RoomCode.ROOM_4);

        assertFalse(roomConnection.isLocked());
    }

}
