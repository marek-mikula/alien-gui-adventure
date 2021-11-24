package en.mikula.adventure.gui;

import en.mikula.adventure.base.game.GuiGame;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.File;
import java.util.Optional;

public class MenuBar implements LayoutPart {

    private final Gui gui;

    private final javafx.scene.control.MenuBar node = new javafx.scene.control.MenuBar();

    public MenuBar(Gui gui) {
        this.gui = gui;
        initNode();
    }

    private void initNode() {
        Menu menuFile = new Menu("File");

        MenuItem menuItemNewGame = new MenuItem("New game");
        MenuItem menuItemEndGame = new MenuItem("End the game");

        menuItemNewGame.setAccelerator(KeyCombination.valueOf("CTRL+T"));
        menuItemEndGame.setAccelerator(KeyCombination.valueOf("CTRL+W"));

        menuItemNewGame.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

            alert.setTitle("Are you sure?");
            alert.setHeaderText("Do you really want to do that?");
            alert.setContentText("Are you sure you want to start a new game? The whole progress will be lost!");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && ButtonType.OK.equals(result.get())) {
                // Close previous primary stage
                gui.getPrimaryStage().close();
                new GuiGame(new Stage()).start();
            }
        });

        menuItemEndGame.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

            alert.setTitle("Are you sure?");
            alert.setHeaderText("Do you really want to do that?");
            alert.setContentText("Are you sure you want to end the game? The whole progress will be lost!");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && ButtonType.OK.equals(result.get())) {
                // Close previous primary stage
                gui.getPrimaryStage().close();
                System.exit(0);
            }
        });

        menuFile.getItems().add(menuItemNewGame);
        menuFile.getItems().add(menuItemEndGame);

        node.getMenus().add(menuFile);

        Menu menuHelp = new Menu("Help");

        MenuItem menuItemHowToPlay = new MenuItem("How to play?");

        menuItemHowToPlay.setOnAction(event -> {
            Stage helpStage = new Stage();

            helpStage.setTitle("How to play?");

            File file = new File("resources/help/index.html");

            WebView webView = new WebView();
            webView.getEngine().load(file.toURI().toString());

            helpStage.setScene(new Scene(webView));
            helpStage.show();
        });

        menuHelp.getItems().add(menuItemHowToPlay);

        node.getMenus().add(menuHelp);
    }

    @Override
    public Node getNode() {
        return node;
    }
}
