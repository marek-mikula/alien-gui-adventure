package en.mikula.adventure.rooms;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class EscapeModuleSector extends Room {

    @Override
    public String getName() {
        return "Escape module sector";
    }

    @Override
    public RoomCode getRoomCode() {
        return RoomCode.ROOM_7;
    }

    @Override
    public RoomCords getCords() {
        return RoomCords.of(723.0, 289.0);
    }

}
