package en.mikula.adventure.gui.terminal;

import en.mikula.adventure.base.game.GuiGame;
import en.mikula.adventure.gui.Input;
import en.mikula.adventure.gui.Output;
import en.mikula.adventure.items.terminals.Terminal;
import en.mikula.adventure.items.terminals.exceptions.TerminalInputException;
import en.mikula.adventure.utils.Observer;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TerminalGui implements Observer {

    private final GuiGame game;

    private final Terminal terminal;

    private final Stage stage = new Stage();

    private final TerminalOptionList terminalOptionList;
    private final Input input;
    private final Output output;

    public TerminalGui(GuiGame game, Terminal terminal) {
        this.game = game;
        this.terminal = terminal;

        terminalOptionList = new TerminalOptionList(this);
        input = new Input();
        output = new Output();

        initGui();
        initObservers();
    }

    private void initGui() {
        stage.setTitle("Terminal - " + terminal.getName());
        stage.setResizable(false);

        VBox vBox = new VBox();

        vBox.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
        vBox.setSpacing(10.0);

        vBox.getChildren().add(terminalOptionList.getNode());
        vBox.getChildren().add(output.getNode());
        vBox.getChildren().add(input.getNode());

        stage.setScene(new Scene(vBox));

        getInput().getNode().requestFocus();
    }

    private void initObservers() {
        input.registerObserver(this);
    }

    public void start() {
        stage.showAndWait();
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public GuiGame getGame() {
        return game;
    }

    public Stage getStage() {
        return stage;
    }

    public TerminalOptionList getTerminalOptionList() {
        return terminalOptionList;
    }

    public Output getOutput() {
        return output;
    }

    public Input getInput() {
        return input;
    }

    @Override
    public void update() {
        String enteredString = input.readInput();

        try {
            terminal.handleInput(enteredString);
        } catch (TerminalInputException exception) {
            output.write(exception.getMessage());
        }
    }
}
