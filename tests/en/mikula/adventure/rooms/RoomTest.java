package en.mikula.adventure.rooms;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.base.game.TextGame;
import en.mikula.adventure.items.CargoSpaceCard;
import en.mikula.adventure.items.Diary;
import en.mikula.adventure.items.Item;
import en.mikula.adventure.rooms.guards.CargoSpaceAlienGuard;
import en.mikula.adventure.rooms.guards.CargoSpacePlatformOpenedGuard;
import en.mikula.adventure.rooms.guards.RoomGuard;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Marek Mikula
 * @version 4/20/2021
 */
public class RoomTest {

    private Game game;

    private Room defaultRoom;

    @Before
    public void setup() {
        defaultRoom = new Cabin();
        game = new TextGame();
    }

    @Test
    public void testAddConnection() {
        Room nextRoom1 = new Cafeteria();
        Room nextRoom2 = new CargoSpace();

        RoomConnection roomConnection1 = new RoomConnection(nextRoom1);
        RoomConnection roomConnection2 = new RoomConnection(nextRoom2);

        assertTrue(defaultRoom.addConnection(roomConnection1));
        assertFalse(defaultRoom.addConnection(roomConnection1));
        assertTrue(defaultRoom.addConnection(roomConnection2));
    }

    @Test
    public void testGetNext() {
        Room nextRoom1 = new Cafeteria();
        Room nextRoom2 = new CargoSpace();

        assertTrue(defaultRoom.addConnection(new RoomConnection(nextRoom1)));
        assertTrue(defaultRoom.addConnection(new RoomConnection(nextRoom2)));

        RoomConnection next1 = defaultRoom.getNext(nextRoom1.getRoomCode().getNumber());
        RoomConnection next2 = defaultRoom.getNext(nextRoom2.getRoomCode().getNumber());

        assertEquals(next1.getNext(), nextRoom1);
        assertEquals(next2.getNext(), nextRoom2);

        assertNull(defaultRoom.getNext(9999));
    }

    @Test
    public void testAddItem() {
        Item item1 = new Diary(game);
        Item item2 = new CargoSpaceCard(game);

        assertTrue(defaultRoom.addItem(item1));
        assertTrue(defaultRoom.addItem(item2));
        assertFalse(defaultRoom.addItem(item2));
    }

    @Test
    public void testGetItems() {
        Item item1 = new Diary(game);
        Item item2 = new CargoSpaceCard(game);

        assertTrue(defaultRoom.addItem(item1));
        assertTrue(defaultRoom.addItem(item2));

        HashSet<Item> itemList = new HashSet<>();

        itemList.add(item1);
        itemList.add(item2);

        assertEquals(itemList, defaultRoom.getItems());

        itemList.remove(item1);

        assertNotEquals(itemList, defaultRoom.getItems());
    }

    @Test
    public void testGetItem() {
        Item item1 = new Diary(game);
        Item item2 = new CargoSpaceCard(game);

        assertTrue(defaultRoom.addItem(item1));
        assertTrue(defaultRoom.addItem(item2));

        assertEquals(item1, defaultRoom.getItem(item1.getCode().getNumber()));
        assertEquals(item2, defaultRoom.getItem(item2.getCode().getNumber()));

        assertNull(defaultRoom.getItem(9999));
    }

    @Test
    public void testAddGuard() {
        RoomGuard guard1 = new CargoSpaceAlienGuard(game);
        RoomGuard guard2 = new CargoSpacePlatformOpenedGuard(game);

        assertTrue(defaultRoom.addGuard(guard1));
        assertTrue(defaultRoom.addGuard(guard2));
        assertTrue(defaultRoom.addGuard(guard2));
    }

    @Test
    public void testGetGuards() {
        RoomGuard guard1 = new CargoSpaceAlienGuard(game);
        RoomGuard guard2 = new CargoSpacePlatformOpenedGuard(game);

        List<RoomGuard> guardList = new ArrayList<>();

        assertTrue(defaultRoom.addGuard(guard1));
        assertTrue(defaultRoom.addGuard(guard2));

        assertTrue(guardList.add(guard1));
        assertTrue(guardList.add(guard2));

        assertEquals(defaultRoom.getGuards(), guardList);
    }

}
