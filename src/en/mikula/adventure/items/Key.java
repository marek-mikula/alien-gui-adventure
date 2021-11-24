package en.mikula.adventure.items;

import en.mikula.adventure.rooms.RoomCode;

/**
 * Common interface for items which allows
 * the item to be used as a key to room
 */
public interface Key {

    /**
     * Method which opens the room
     *
     * @param roomCode of room which we are trying to open
     * @return string which tells us if we were successful
     * or not
     */
    public String open(RoomCode roomCode);

}
