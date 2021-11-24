package en.mikula.adventure.rooms;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class CargoSpaceControl extends Room {

    @Override
    public String getName() {
        return "Cargo space control room";
    }

    @Override
    public RoomCode getRoomCode() {
        return RoomCode.ROOM_3;
    }

    @Override
    public RoomCords getCords() {
        return RoomCords.of(393.0, 498.0);
    }

}
