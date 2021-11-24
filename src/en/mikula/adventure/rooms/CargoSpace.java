package en.mikula.adventure.rooms;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class CargoSpace extends Room {

    private boolean isRampOpened = false;

    private boolean isAlienHere = true;

    public void setIsRampOpened(boolean isRampOpened) {
        this.isRampOpened = isRampOpened;
    }

    public boolean isRampOpened() {
        return isRampOpened;
    }

    public void setIsAlienHere(boolean isAlienHere) {
        this.isAlienHere = isAlienHere;
    }

    public boolean isAlienHere() {
        return isAlienHere;
    }

    @Override
    public String getName() {
        return "Cargo space";
    }

    @Override
    public RoomCode getRoomCode() {
        return RoomCode.ROOM_4;
    }

    @Override
    public RoomCords getCords() {
        return RoomCords.of(74.0, 289.0);
    }

}
