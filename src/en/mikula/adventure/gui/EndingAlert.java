package en.mikula.adventure.gui;

import en.mikula.adventure.base.game.GuiGame;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class EndingAlert {

    public static void show(GuiGame game) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("The end");
        alert.setHeaderText("The end");
        alert.setContentText("Thanks for playing, Marek Mikula");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && ButtonType.OK.equals(result.get())) {
            // Close previous primary stage
            game.getGui().getPrimaryStage().close();
            System.exit(0);
        }
    }

}
