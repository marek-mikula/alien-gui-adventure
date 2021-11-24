package en.mikula.adventure.rooms;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class Cafeteria extends Room {

    @Override
    public String getName() {
        return "Cafeteria";
    }

    @Override
    public RoomCode getRoomCode() {
        return RoomCode.ROOM_2;
    }

    @Override
    public RoomCords getCords() {
        return RoomCords.of(302.0, 289.0);
    }

}
