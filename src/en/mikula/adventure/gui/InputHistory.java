package en.mikula.adventure.gui;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.util.LinkedList;

public class InputHistory {

    private final TextField node;

    /**
     * Stack of previous commands
     */
    private final LinkedList<String> commands = new LinkedList<>();

    /**
     * Current pointer to command in history queue
     * null means current command user is writing
     * <p>
     * Item with lower index is older!
     */
    private Integer pointer = null;

    private String concept = null;

    public InputHistory(TextField node) {
        this.node = node;
        initKeyEvents();
    }

    private void initKeyEvents() {
        // Allow user use command history
        node.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.UP)) {
                previousCommand();
            } else if (event.getCode().equals(KeyCode.DOWN)) {
                nextCommand();
            }
        });
    }

    private void previousCommand() {
        if (commands.size() == 0 || (pointer != null && pointer == commands.size())) {
            return;
        }

        pointer = pointer == null ? 1 : (pointer + 1);

        if (pointer == 1) { // Save concept text
            concept = node.getText();
        }

        node.setText(commands.get(commands.size() - pointer));
    }

    private void nextCommand() {
        if (pointer == null) {
            return;
        }

        pointer = pointer == 1 ? null : (pointer - 1);

        if (pointer == null) {
            node.setText(concept);
        } else {
            node.setText(commands.get(commands.size() - pointer));
        }
    }

    /**
     * Resets the pointer and concept command
     */
    public void reset() {
        pointer = null;
        concept = null;
    }

    /**
     * Adds new command to queue
     *
     * @param command to be added
     */
    public void add(String command) {
        commands.addLast(command);
        reset();
    }

}
