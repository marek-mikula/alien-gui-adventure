package en.mikula.adventure.rooms;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class Bridge extends Room {

    @Override
    public String getName() {
        return "Command bridge";
    }

    @Override
    public RoomCode getRoomCode() {
        return RoomCode.ROOM_1;
    }

    @Override
    public RoomCords getCords() {
        return RoomCords.of(393.0, 77.0);
    }

}
