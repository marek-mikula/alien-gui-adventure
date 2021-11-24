package en.mikula.adventure.gui;

import en.mikula.adventure.items.Item;
import en.mikula.adventure.utils.ItemUtils;
import en.mikula.adventure.utils.Observer;
import javafx.scene.Node;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InventoryList implements LayoutPart, Observer {

    private final Gui gui;

    private final TitledPane node = new TitledPane();
    private final FlowPane flowPane = new FlowPane();

    public InventoryList(Gui gui) {
        this.gui = gui;
        initNode();
    }

    private void initNode() {
        node.setContent(flowPane);
        node.setMaxHeight(200.0);
        fillList();
        updateTitle();
    }

    private void fillList() {
        // Clear the items in the flow pane first
        flowPane.getChildren().clear();

        boolean hasItems = false;

        for (Item item : gui.getGame().getInventory().getItems()) {
            InputStream stream;
            try {
                stream = new FileInputStream(item.getImagePath());
            } catch (IOException exception) {
                continue;
            }

            Image image = new Image(stream, 40, 40, true, true);

            ImageView imageView = new ImageView(image);

            // Add image tooltip with item name and number
            Tooltip.install(imageView, new Tooltip(ItemUtils.formatName(item)));

            flowPane.getChildren().add(imageView);

            hasItems = true;
        }

        // Add empty inventory indicator
        if (!hasItems) {
            flowPane.getChildren().add(new Text("Inventory is empty"));
        }
    }

    private void updateTitle() {
        int inventorySize = gui.getGame().getInventory().getItems().size();
        node.setText("Inventory (" + inventorySize + ")");
    }

    @Override
    public Node getNode() {
        return node;
    }

    @Override
    public void update() {
        fillList();
        updateTitle();
    }
}
