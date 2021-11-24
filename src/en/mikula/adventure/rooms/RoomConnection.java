package en.mikula.adventure.rooms;

import java.util.Objects;

/**
 * Room connection is used to connect rooms and let
 * the connection to have states (blocked, locked etc.)
 *
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class RoomConnection {

    /**
     * next room reference
     */
    private final Room next;

    /**
     * locked state
     */
    private boolean isLocked = false;

    /**
     * blocked state, can't be changed!
     * It's just used to differ the blocked
     * and locked state and show different message
     */
    private boolean isBlocked = false;

    public RoomConnection(Room next) {
        this.next = next;
    }

    /**
     * Sets locked state
     *
     * @param isLocked state
     * @return self instance
     */
    public RoomConnection setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
        return this;
    }

    /**
     * Sets blocked state
     *
     * @param isBlocked state
     * @return self instance
     */
    public RoomConnection setIsBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
        return this;
    }

    /**
     * @return locked state
     */
    public boolean isLocked() {
        return isLocked;
    }

    /**
     * @return blocked state
     */
    public boolean isBlocked() {
        return isBlocked;
    }

    /**
     * @return reference to the next room
     */
    public Room getNext() {
        return next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RoomConnection roomConnection = (RoomConnection) o;
        return next.equals(roomConnection.getNext());
    }

    @Override
    public int hashCode() {
        return Objects.hash(next);
    }

}
