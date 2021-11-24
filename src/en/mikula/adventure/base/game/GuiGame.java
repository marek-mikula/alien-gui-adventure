package en.mikula.adventure.base.game;

import en.mikula.adventure.gui.EndingAlert;
import en.mikula.adventure.gui.Gui;
import en.mikula.adventure.text.GameText;
import en.mikula.adventure.utils.Observer;
import javafx.stage.Stage;

/**
 * GuiGame class which handles the game while in GUI mode
 * @see en.mikula.adventure.Main for how the GUI mode works
 * Also implements observer to observe changes on text input.
 * Gui game has slightly different command lifecycle.
 * 1. user writes the command into the input of the gui
 * @see en.mikula.adventure.gui.Input
 * 2. once the user submits the command, the command bar notifies
 * the observers (the gui game)
 * 3. game proceeds to the update method to reads the submited command
 * and sends the result into the console output gui part
 */
public class GuiGame extends Game implements Observer {

    private final Gui gui;

    public GuiGame(Stage primaryStage) {
        super();

        gui = new Gui(this, primaryStage);

        // Register observers after whole Gui has loaded
        // to be sure we have all the dependencies
        registerObservers();
    }

    private void registerObservers() {
        // Setup observer for command bar to read commands
        gui.getInput().registerObserver(this);

        // Register observer for inventory list
        inventory.registerObserver(gui.getInventoryList());

        // Register map indicator observer and exits list observer
        map.registerObserver(gui.getMapIndicator());
        map.registerObserver(gui.getExitsList());
    }

    @Override
    public void start() {
        gui.getPrimaryStage().show();

        // Show starting text
        gui.getOutput().write(GameText.startingText());
    }

    @Override
    public String getMode() {
        return Game.MODE_GUI;
    }

    @Override
    public void update() {
        String output;

        try {
            output = commandReader.readCommand();
        } catch (RuntimeException exception) {
            output = exception.getMessage();
        }

        gui.getOutput().write(output);

        if (hasEnded) {
            EndingAlert.show(this);
        }
    }

    public Gui getGui() {
        return gui;
    }

}
