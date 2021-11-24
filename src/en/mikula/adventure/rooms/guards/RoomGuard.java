package en.mikula.adventure.rooms.guards;

/**
 * Common room guard interface which allows us
 * to create the room guards which checks some
 * condition before entering the room
 */
public interface RoomGuard {

    /**
     * Checks the specific condition which muset be
     * true to let player in
     *
     * @return true if player can enter, otherwise false
     */
    public boolean passed();

    /**
     * Gets the error message if the condition
     * failed
     *
     * @return string error message
     */
    public String errorMessage();

}
