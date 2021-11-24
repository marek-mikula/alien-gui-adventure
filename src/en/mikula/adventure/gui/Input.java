package en.mikula.adventure.gui;

import en.mikula.adventure.utils.Observable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class Input extends Observable implements LayoutPart {

    private final TextField node = new TextField();

    private final InputHistory inputHistory = new InputHistory(node);

    public Input() {
        initNode();
    }

    private void initNode() {
        node.setOnAction(event -> notifyObservers());
        node.setPromptText("Enter your command");
        node.setFont(new Font("Consolas", 16));
    }

    @Override
    public Node getNode() {
        return node;
    }

    /**
     * Reads user submitted input, clears the input and
     * returns it
     */
    public String readInput() {
        String input = node.getText();

        node.setText("");

        inputHistory.add(input); // Add command to history

        return input;
    }

}
