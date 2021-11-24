package en.mikula.adventure.gui;

import en.mikula.adventure.rooms.RoomCords;
import en.mikula.adventure.utils.Observer;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.IOException;

public class MapIndicator implements LayoutPart, Observer {

    private final Gui gui;

    private final ImageView node = new ImageView();

    public MapIndicator(Gui gui) {
        this.gui = gui;

        initNode();
    }

    private void initNode() {
        node.setImage(getImage());

        // Get starting room cords
        RoomCords cords = gui.getGame().getMap().getCurrentRoom().getCords();

        // Always reduce the number by half of the size of the image
        node.setTranslateX(cords.getX() - 25.0);
        node.setTranslateY(cords.getY() - 25.0);

        // Add player tooltip
        Tooltip.install(node, new Tooltip("Ellen Ripley"));
    }

    /**
     * Loads image by current state
     *
     * @return image instance
     */
    private Image getImage() {
        FileInputStream stream;
        try {
            stream = new FileInputStream("resources/player.png");
        } catch (IOException exception) {
            stream = null;
        }

        if (stream == null) {
            throw new RuntimeException("Could not load map indicator image!");
        }

        return new Image(stream, 50.0, 50.0, true, true);
    }

    @Override
    public Node getNode() {
        return node;
    }

    @Override
    public void update() {
        // Get current room cords
        RoomCords cords = gui.getGame().getMap().getCurrentRoom().getCords();

        TranslateTransition transition = new TranslateTransition();

        transition.setNode(node);
        transition.setDuration(Duration.millis(500));
        transition.setToX(cords.getX() - 25.0);
        transition.setToY(cords.getY() - 25.0);

        transition.play();
    }
}
