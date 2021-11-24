package en.mikula.adventure.gui.template;

import en.mikula.adventure.gui.*;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.*;

public class LeftColumn implements LayoutPart {

    private final Input input;

    private final Output output;

    private final InventoryList inventoryList;

    private final ExitsList exitsList;

    private final VBox node = new VBox();

    public LeftColumn(Gui gui) {
        input = new Input();
        output = new Output();
        inventoryList = new InventoryList(gui);
        exitsList = new ExitsList(gui);

        initNode();
    }

    private void initNode() {
        // Add list of exits
        node.getChildren().add(exitsList.getNode());

        // Add inventory list to horizontal box
        node.getChildren().add(inventoryList.getNode());

        // Allow textarea to grow on size
        VBox.setVgrow(output.getNode(), Priority.ALWAYS);

        // Add console output
        node.getChildren().add(output.getNode());

        // Add command bar a last node
        node.getChildren().add(input.getNode());

        node.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
        node.setSpacing(10.0);
    }

    public Output getOutput() {
        return output;
    }

    public Input getInput() {
        return input;
    }

    public InventoryList getInventoryList() {
        return inventoryList;
    }

    public ExitsList getExitsList() {
        return exitsList;
    }

    @Override
    public Node getNode() {
        return node;
    }

}
