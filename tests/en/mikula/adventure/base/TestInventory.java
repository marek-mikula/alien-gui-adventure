package en.mikula.adventure.base;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.base.game.TextGame;
import en.mikula.adventure.items.CargoSpaceCard;
import en.mikula.adventure.items.Item;
import en.mikula.adventure.items.Screwdriver;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author Marek Mikula
 * @version 4/23/2021
 */
public class TestInventory {

    private Inventory inventory;

    private Game game;

    @Before
    public void setup() {
        inventory = new Inventory();
        game = new TextGame();
    }

    @Test
    public void testAddItem() {
        CargoSpaceCard cargoSpaceCard = new CargoSpaceCard(game);
        Screwdriver screwdriver = new Screwdriver(game);

        assertTrue(inventory.addItem(cargoSpaceCard));
        assertTrue(inventory.addItem(screwdriver));
        assertFalse(inventory.addItem(screwdriver));
    }

    @Test
    public void testRemoveItem() {
        CargoSpaceCard cargoSpaceCard = new CargoSpaceCard(game);
        Screwdriver screwdriver = new Screwdriver(game);

        assertTrue(inventory.addItem(cargoSpaceCard));
        assertTrue(inventory.addItem(screwdriver));

        assertTrue(inventory.removeItem(cargoSpaceCard));
        assertTrue(inventory.removeItem(screwdriver));

        assertFalse(inventory.removeItem(cargoSpaceCard));
        assertFalse(inventory.removeItem(screwdriver));
    }

    @Test
    public void testGetItems() {
        CargoSpaceCard cargoSpaceCard = new CargoSpaceCard(game);
        Screwdriver screwdriver = new Screwdriver(game);

        assertTrue(inventory.addItem(cargoSpaceCard));
        assertTrue(inventory.addItem(screwdriver));

        Set<Item> itemList = new HashSet<>();

        itemList.add(cargoSpaceCard);
        itemList.add(screwdriver);

        assertEquals(itemList, inventory.getItems());

        assertTrue(inventory.removeItem(cargoSpaceCard));

        assertNotEquals(itemList, inventory.getItems());
    }

    @Test
    public void testGetItem() {
        CargoSpaceCard cargoSpaceCard = new CargoSpaceCard(game);
        Screwdriver screwdriver = new Screwdriver(game);

        assertTrue(inventory.addItem(cargoSpaceCard));
        assertTrue(inventory.addItem(screwdriver));

        assertEquals(cargoSpaceCard, inventory.getItem(cargoSpaceCard.getCode().getNumber()));
        assertEquals(screwdriver, inventory.getItem(screwdriver.getCode().getNumber()));

        assertNull(inventory.getItem(9999));
    }

}
