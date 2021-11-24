package en.mikula.adventure;

import en.mikula.adventure.base.game.Game;
import en.mikula.adventure.base.game.GuiGame;
import en.mikula.adventure.base.game.TextGame;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        String selectedMode = args.length > 0 ? args[0] : Game.MODE_GUI;

        if (selectedMode.equals(Game.MODE_GUI)) {
            launch(args);
        } else if (selectedMode.equals(Game.MODE_TEXT)) {
            new TextGame().start();
        } else {
            throw new IllegalArgumentException(String.format(
                    "Invalid application mode [%s] selected. Mode can be either [%s] or [%s].",
                    selectedMode,
                    Game.MODE_GUI,
                    Game.MODE_TEXT
            ));
        }
    }

    @Override
    public void start(Stage primaryStage) {
        new GuiGame(primaryStage).start();
    }

}
