package en.mikula.adventure.items;

/**
 * Common item interface which allows
 * player to interact with an item
 *
 * @author Marek Mikula
 * @version 4/9/2021
 */
public interface Interactive {

    /**
     * Main method which specifies how the
     * interaction is being done with the
     * item
     *
     * @return string text to show to user
     */
    public String interact();

}
