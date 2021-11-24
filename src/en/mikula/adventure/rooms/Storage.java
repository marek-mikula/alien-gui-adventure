package en.mikula.adventure.rooms;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class Storage extends Room {

    @Override
    public String getName() {
        return "Storage room";
    }

    @Override
    public RoomCode getRoomCode() {
        return RoomCode.ROOM_5;
    }

    @Override
    public RoomCords getCords() {
        return RoomCords.of(133.0, 666.0);
    }

}
