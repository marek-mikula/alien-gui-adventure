package en.mikula.adventure.gui.template;

import en.mikula.adventure.gui.Gui;
import en.mikula.adventure.gui.LayoutPart;
import en.mikula.adventure.gui.MenuBar;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class MainVerticalColumn implements LayoutPart {

    private final VBox node = new VBox();

    private final MainHorizontalRow mainHorizontalRow;

    private final MenuBar menuBar;

    public MainVerticalColumn(Gui gui) {
        mainHorizontalRow = new MainHorizontalRow(gui);
        menuBar = new MenuBar(gui);

        initNode();
    }

    private void initNode() {
        node.getChildren().add(menuBar.getNode());
        node.getChildren().add(mainHorizontalRow.getNode());
    }

    public MainHorizontalRow getMainHorizontalRow() {
        return mainHorizontalRow;
    }

    @Override
    public Node getNode() {
        return node;
    }

}
