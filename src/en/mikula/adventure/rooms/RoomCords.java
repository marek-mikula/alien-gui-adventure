package en.mikula.adventure.rooms;

public class RoomCords {

    private final double x;
    private final double y;

    private RoomCords(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static RoomCords of(double x, double y) {
        return new RoomCords(x, y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
