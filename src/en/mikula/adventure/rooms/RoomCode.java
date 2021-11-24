package en.mikula.adventure.rooms;

/**
 * Room code enum used to alias the rooms
 * with a code so the user does not have to
 * input the whole room names
 *
 * @author Marek Mikula
 * @version 4/9/2021
 */
public enum RoomCode {
    ROOM_0(0), // Ellen Ripley's cabin
    ROOM_1(1), // Bridge
    ROOM_2(2), // Cafeteria
    ROOM_3(3), // Cargo space control room
    ROOM_4(4), // Cargo space
    ROOM_5(5), // Storage
    ROOM_6(6), // Ventilation
    ROOM_7(7); // Escape module sector

    private final int number;

    private RoomCode(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
