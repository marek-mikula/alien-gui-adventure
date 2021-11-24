package en.mikula.adventure.items;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.rooms.EscapeModuleSector;
import en.mikula.adventure.rooms.RoomCode;

/**
 * @author Marek Mikula
 * @version 4/9/2021
 */
public class EscapeModule extends Item implements Interactive {

    private final Game game;

    private boolean isModuleReady = false;

    public EscapeModule(Game game) {
        this.game = game;
    }

    public void setIsModuleReady(boolean isModuleReady) {
        this.isModuleReady = isModuleReady;
    }

    public boolean isModuleReady() {
        return isModuleReady;
    }

    @Override
    public String getName() {
        return "Escape module";
    }

    @Override
    public ItemCode getCode() {
        return ItemCode.ITEM_6;
    }

    @Override
    public String interact() {
        if (!isModuleReady) {
            return "The module is not ready to go. You have to prepare the module trough the terminal.";
        }

        // End the main game loop
        game.setHasEnded(true);

        return "You successfully escaped the ship!";
    }
}
