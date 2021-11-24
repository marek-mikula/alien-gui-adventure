package en.mikula.adventure.gui.template;

import en.mikula.adventure.gui.Gui;
import en.mikula.adventure.gui.LayoutPart;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class MainHorizontalRow implements LayoutPart {

    private final Gui gui;

    private final LeftColumn leftColumn;
    private final RightColumn rightColumn;

    private final HBox node = new HBox();

    public MainHorizontalRow(Gui gui) {
        this.gui = gui;

        leftColumn = new LeftColumn(gui);
        rightColumn = new RightColumn(gui);

        initNode();
    }

    private void initNode() {
        node.getChildren().add(leftColumn.getNode());
        node.getChildren().add(rightColumn.getNode());
    }

    public LeftColumn getLeftColumn() {
        return leftColumn;
    }

    public RightColumn getRightColumn() {
        return rightColumn;
    }

    @Override
    public Node getNode() {
        return node;
    }

}
