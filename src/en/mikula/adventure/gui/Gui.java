package en.mikula.adventure.gui;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.base.game.GuiGame;
import en.mikula.adventure.gui.template.MainVerticalColumn;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Gui {

    private final GuiGame game;

    private final Stage primaryStage;

    private final MainVerticalColumn mainVerticalColumn;

    public Gui(GuiGame game, Stage primaryStage) {
        this.game = game;
        this.primaryStage = primaryStage;

        mainVerticalColumn = new MainVerticalColumn(this);

        initPrimaryStage();

        // Focus input field in GUI
        getInput().getNode().requestFocus();
    }

    private void initPrimaryStage() {
        // Set title of the stage
        primaryStage.setTitle(Game.GAME_NAME);

        primaryStage.setResizable(false);

        primaryStage.setScene(new Scene((Parent) mainVerticalColumn.getNode()));
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public GuiGame getGame() {
        return game;
    }

    public Output getOutput() {
        return mainVerticalColumn.getMainHorizontalRow().getLeftColumn().getOutput();
    }

    public Input getInput() {
        return mainVerticalColumn.getMainHorizontalRow().getLeftColumn().getInput();
    }

    public InventoryList getInventoryList() {
        return mainVerticalColumn.getMainHorizontalRow().getLeftColumn().getInventoryList();
    }

    public MapIndicator getMapIndicator() {
        return mainVerticalColumn.getMainHorizontalRow().getRightColumn().getMapIndicator();
    }

    public ExitsList getExitsList() {
        return mainVerticalColumn.getMainHorizontalRow().getLeftColumn().getExitsList();
    }

    public Map getMap() {
        return mainVerticalColumn.getMainHorizontalRow().getRightColumn().getMap();
    }

}
