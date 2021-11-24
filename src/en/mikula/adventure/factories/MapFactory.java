package en.mikula.adventure.factories;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.base.Map;
import en.mikula.adventure.items.*;
import en.mikula.adventure.items.terminals.bridge.BridgeTerminal;
import en.mikula.adventure.items.terminals.bridge.ShowLastDiaryEntryOption;
import en.mikula.adventure.items.terminals.bridge.ShowStatusOfEscapeModulesOption;
import en.mikula.adventure.items.terminals.cargoSpace.EnterCodeToStorageRoomOption;
import en.mikula.adventure.items.terminals.cargoSpaceControl.CargoSpaceControlTerminal;
import en.mikula.adventure.items.terminals.cargoSpace.CargoSpaceTerminal;
import en.mikula.adventure.items.terminals.cargoSpaceControl.CloseCargoPlatformOption;
import en.mikula.adventure.items.terminals.cargoSpaceControl.OpenCargoPlatformOption;
import en.mikula.adventure.items.terminals.escapeModuleSector.EscapeModuleSectorTerminal;
import en.mikula.adventure.items.terminals.escapeModuleSector.GetEscapeModuleReadyOption;
import en.mikula.adventure.rooms.*;
import en.mikula.adventure.rooms.guards.CargoSpaceAlienGuard;
import en.mikula.adventure.rooms.guards.CargoSpacePlatformOpenedGuard;

/**
 * Factory used to build the map
 *
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class MapFactory {

    /**
     * Builds the rooms filled with guards, items
     * and their connections
     * <p>
     * Sets the default room to cabin
     *
     * @param game game instance
     * @return built map
     */
    public static Map buildMap(Game game) {
        Map map = new Map();

        Room bridge = new Bridge();
        Room cabin = new Cabin();
        Room cafeteria = new Cafeteria();
        Room cargoSpace = new CargoSpace();
        Room cargoSpaceControl = new CargoSpaceControl();
        Room escapeModuleSector = new EscapeModuleSector();
        Room storage = new Storage();
        Room ventilation = new Ventilation();

        // Add guards

        cargoSpace.addGuard(new CargoSpaceAlienGuard(game));
        cargoSpace.addGuard(new CargoSpacePlatformOpenedGuard(game));

        // Add items to the rooms

        BridgeTerminal bridgeTerminal = new BridgeTerminal(game);
        CargoSpaceControlTerminal cargoSpaceControlTerminal = new CargoSpaceControlTerminal(game);
        CargoSpaceTerminal cargoSpaceTerminal = new CargoSpaceTerminal(game);
        EscapeModuleSectorTerminal escapeModuleSectorTerminal = new EscapeModuleSectorTerminal(game);

        bridgeTerminal.addOption(new ShowLastDiaryEntryOption(bridgeTerminal));
        bridgeTerminal.addOption(new ShowStatusOfEscapeModulesOption(bridgeTerminal));

        cargoSpaceTerminal.addOption(new EnterCodeToStorageRoomOption(cargoSpaceTerminal, game));

        cargoSpaceControlTerminal.addOption(new CloseCargoPlatformOption(cargoSpaceControlTerminal, game));
        cargoSpaceControlTerminal.addOption(new OpenCargoPlatformOption(cargoSpaceControlTerminal, game));

        escapeModuleSectorTerminal.addOption(new GetEscapeModuleReadyOption(escapeModuleSectorTerminal, game));

        cabin.addItem(new Diary(game));
        cafeteria.addItem(new CommandersBody(game));
        bridge.addItem(bridgeTerminal);
        cargoSpaceControl.addItem(cargoSpaceControlTerminal);
        cargoSpace.addItem(new Screwdriver(game));
        cargoSpace.addItem(cargoSpaceTerminal);
        escapeModuleSector.addItem(escapeModuleSectorTerminal);
        escapeModuleSector.addItem(new EscapeModule(game));

        // Create connections between rooms

        cabin.addConnection(new RoomConnection(bridge));

        bridge.addConnection(new RoomConnection(cabin));
        bridge.addConnection(new RoomConnection(cafeteria));
        bridge.addConnection(new RoomConnection(cargoSpace).setIsLocked(true));

        escapeModuleSector.addConnection(new RoomConnection(ventilation));
        escapeModuleSector.addConnection(new RoomConnection(cafeteria).setIsBlocked(true));

        cafeteria.addConnection(new RoomConnection(bridge));
        cafeteria.addConnection(new RoomConnection(cargoSpaceControl));
        cafeteria.addConnection(new RoomConnection(escapeModuleSector).setIsBlocked(true));

        cargoSpaceControl.addConnection(new RoomConnection(cafeteria));

        cargoSpace.addConnection(new RoomConnection(bridge));
        cargoSpace.addConnection(new RoomConnection(storage).setIsLocked(true));

        storage.addConnection(new RoomConnection(cargoSpace));
        storage.addConnection(new RoomConnection(ventilation).setIsLocked(true));

        ventilation.addConnection(new RoomConnection(storage));
        ventilation.addConnection(new RoomConnection(escapeModuleSector));

        // Add rooms to the set

        map.addRoom(bridge);
        map.addRoom(cabin);
        map.addRoom(cafeteria);
        map.addRoom(cargoSpace);
        map.addRoom(cargoSpaceControl);
        map.addRoom(escapeModuleSector);
        map.addRoom(storage);
        map.addRoom(ventilation);

        // Set default room
        map.changeCurrentRoom(map.getRoom(Map.STARTING_ROOM), true);

        return map;
    }

}
