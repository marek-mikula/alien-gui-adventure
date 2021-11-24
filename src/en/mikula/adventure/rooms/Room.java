package en.mikula.adventure.rooms;

import en.mikula.adventure.items.Item;
import en.mikula.adventure.items.ItemCode;
import en.mikula.adventure.rooms.guards.RoomGuard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * Abstract class for all rooms
 *
 * @author Marek Mikula
 * @version 4/9/2021
 */
public abstract class Room {

    /**
     * Connections to other rooms
     */
    private final HashSet<RoomConnection> connections = new HashSet<>();

    /**
     * Items in the room
     */
    private final HashSet<Item> items = new HashSet<>();

    /**
     * Room guards, List is used to maintain the order
     */
    private final List<RoomGuard> guards = new ArrayList<>();

    /**
     * Adds a new connection to the set
     *
     * @param roomConnection specifies the landing room
     * @return boolean if added, otherwise false
     */
    public boolean addConnection(RoomConnection roomConnection) {
        return connections.add(roomConnection);
    }

    /**
     * @return all connections connected to current room
     */
    public HashSet<RoomConnection> getConnections() {
        return connections;
    }

    /**
     * Gets the next connection if any
     *
     * @param roomCode the room code which should correspond
     *                 with the code of the next room
     * @return RoomConnection or null if not found
     * @see RoomCode
     */
    public RoomConnection getNext(int roomCode) {
        for (RoomConnection roomConnection : connections) {
            if (roomConnection.getNext().getRoomCode().getNumber() == roomCode) {
                return roomConnection;
            }
        }

        return null;
    }

    /**
     * Adds an item to the room
     *
     * @param item to be added
     * @return boolean if successful
     */
    public boolean addItem(Item item) {
        return items.add(item);
    }

    /**
     * Gets all items in the room
     *
     * @return set of room items
     */
    public HashSet<Item> getItems() {
        return items;
    }

    /**
     * Removes an item from the room
     *
     * @param item to be removed
     * @return boolean if successful
     */
    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    /**
     * Gets the item by item code
     *
     * @param itemCode integer item code
     * @return item if any
     * @see ItemCode
     */
    public Item getItem(int itemCode) {
        for (Item item : items) {
            if (item.getCode().getNumber() == itemCode) {
                return item;
            }
        }

        return null;
    }

    /**
     * Adds guard to the room
     *
     * @param guard to be added
     * @return boolean if successful
     */
    public boolean addGuard(RoomGuard guard) {
        return guards.add(guard);
    }

    /**
     * @return all room guards
     */
    public List<RoomGuard> getGuards() {
        return guards;
    }

    /**
     * @return room name
     */
    public abstract String getName();

    /**
     * @return room code
     */
    public abstract RoomCode getRoomCode();

    /**
     * @return DTO containing cords of the room in map
     */
    public abstract RoomCords getCords();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Room room = (Room) o;
        return room.getRoomCode().equals(getRoomCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoomCode().getNumber());
    }

}
