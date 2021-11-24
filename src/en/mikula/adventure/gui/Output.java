package en.mikula.adventure.gui;

import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

public class Output implements LayoutPart {

    private final TextArea node = new TextArea();

    public Output() {
        initNode();
    }

    private void initNode() {
        node.setEditable(false);
        node.setFont(new Font("Consolas", 16));
        node.setWrapText(true);
    }

    /**
     * Writes a line into output gui part
     * Prepends a trailing ">" character before
     */
    public void write(String output) {
        // Prepend before the output new empty line
        // if the textarea already has some text
        if (node.getText().trim().length() > 0) {
            node.appendText("\n\n");
        }

        node.appendText("> ");

        node.appendText(output);
    }

    /**
     * Clears the output
     */
    public void clear() {
        node.clear();
    }

    @Override
    public Node getNode() {
        return node;
    }
}
