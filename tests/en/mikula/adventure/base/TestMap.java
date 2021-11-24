package en.mikula.adventure.base;

import en.mikula.adventure.rooms.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Marek Mikula
 * @version 4/23/2021
 */
public class TestMap {

    private Map map;

    @Before
    public void setup() {
        map = new Map();
    }

    @Test
    public void testGetCurrentRoom() {
        Room bridge = new Bridge();
        Room cabin = new Cabin();

        map.changeCurrentRoom(bridge, true);

        assertEquals(bridge, map.getCurrentRoom());

        map.changeCurrentRoom(cabin, true);

        assertNotEquals(bridge, map.getCurrentRoom());
        assertEquals(cabin, map.getCurrentRoom());
    }

    @Test
    public void testGetPreviousRoom() {
        Room bridge = new Bridge();
        Room cabin = new Cabin();

        map.changeCurrentRoom(bridge, true);

        assertNull(map.getPreviousRoom());

        map.changeCurrentRoom(cabin, true);

        assertEquals(bridge, map.getPreviousRoom());

        map.changeCurrentRoom(bridge, true);

        assertEquals(cabin, map.getPreviousRoom());
    }

    @Test
    public void testAddRoom() {
        Room bridge = new Bridge();
        Room cabin = new Cabin();

        assertTrue(map.addRoom(bridge));
        assertTrue(map.addRoom(cabin));
        assertFalse(map.addRoom(cabin));
    }

    @Test
    public void testChangeCurrentRoom() {
        Room bridge = new Bridge();
        Room cabin = new Cabin();

        map.changeCurrentRoom(bridge, true);

        assertEquals(bridge, map.getCurrentRoom());

        map.changeCurrentRoom(cabin, true);

        assertEquals(cabin, map.getCurrentRoom());
    }

    @Test
    public void testGetRoom() {
        Room bridge = new Bridge();
        Room cabin = new Cabin();

        assertTrue(map.addRoom(bridge));
        assertTrue(map.addRoom(cabin));

        assertEquals(bridge, map.getRoom(bridge.getRoomCode()));
        assertEquals(cabin, map.getRoom(cabin.getRoomCode()));
    }

}
