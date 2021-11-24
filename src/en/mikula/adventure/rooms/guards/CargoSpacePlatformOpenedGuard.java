package en.mikula.adventure.rooms.guards;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.rooms.CargoSpace;
import en.mikula.adventure.rooms.RoomCode;

/**
 * @author Marek Mikula
 * @version 4/10/2021
 */
public class CargoSpacePlatformOpenedGuard implements RoomGuard {

    private final Game game;

    public CargoSpacePlatformOpenedGuard(Game game) {
        this.game = game;
    }

    @Override
    public boolean passed() {
        // Is the ramp still opened?
        return !(((CargoSpace) game.getMap().getRoom(RoomCode.ROOM_4)).isRampOpened());
    }

    @Override
    public String errorMessage() {
        return "You can't enter the cargo space if the platform is opened! The compression would kill you! First close the platform!";
    }

}
