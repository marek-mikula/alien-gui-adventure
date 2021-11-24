package en.mikula.adventure.gui.template;

import en.mikula.adventure.gui.Gui;
import en.mikula.adventure.gui.LayoutPart;
import en.mikula.adventure.gui.Map;
import en.mikula.adventure.gui.MapIndicator;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class RightColumn implements LayoutPart {

    private final AnchorPane node = new AnchorPane();

    private final Map map;

    private final MapIndicator mapIndicator;

    public RightColumn(Gui gui) {
        map = new Map();
        mapIndicator = new MapIndicator(gui);

        initNode();
    }

    private void initNode() {
        node.getChildren().add(map.getNode());
        node.getChildren().add(mapIndicator.getNode());
    }

    @Override
    public Node getNode() {
        return node;
    }

    public MapIndicator getMapIndicator() {
        return mapIndicator;
    }

    public Map getMap() {
        return map;
    }

}
