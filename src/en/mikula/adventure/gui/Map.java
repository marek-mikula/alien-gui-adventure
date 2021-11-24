package en.mikula.adventure.gui;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;

public class Map implements LayoutPart {

    public static int STATE_DEFAULT = 0;
    public static int STATE_WITHOUT_ALIENS = 1;

    private int state = STATE_DEFAULT;

    private final ImageView node = new ImageView();

    public Map() {
        initNode();
    }

    private void initNode() {
        node.setImage(getImage());
    }

    /**
     * Loads image by current state
     *
     * @return image instance
     */
    private Image getImage() {
        String fileName;

        if (state == STATE_WITHOUT_ALIENS) {
            fileName = "map_without_aliens.png";
        } else {
            fileName = "map_default.png";
        }

        FileInputStream stream;
        try {
            stream = new FileInputStream("resources/map/" + fileName);
        } catch (IOException exception) {
            stream = null;
        }

        if (stream == null) {
            throw new RuntimeException("Could not load map image!");
        }

        return new Image(stream, 800.0, 800.0, true, true);
    }

    public void setState(int state) {
        this.state = state;
        this.initNode();
    }

    @Override
    public Node getNode() {
        return node;
    }
}
