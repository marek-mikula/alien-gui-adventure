package en.mikula.adventure.gui.terminal;

import en.mikula.adventure.gui.LayoutPart;
import en.mikula.adventure.items.terminals.exceptions.TerminalInputException;
import en.mikula.adventure.utils.Observer;
import en.mikula.adventure.utils.TerminalUtils;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class TerminalOptionList implements LayoutPart, Observer {

    private final TerminalGui terminalGui;

    private final ListView<String> node = new ListView<>();

    public TerminalOptionList(TerminalGui terminalGui) {
        this.terminalGui = terminalGui;
        initNode();
    }

    private void initNode() {
        node.setMaxHeight(100.0);

        // Set selection mode to single
        node.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        node.setOnMouseClicked(event -> {
            String text = node.getSelectionModel().getSelectedItem();

            if (text == null) {
                return;
            }

            int optionNumber;
            try {
                optionNumber = TerminalUtils.extractOptionNumber(text);
                terminalGui.getTerminal().handleInput(optionNumber + "");
            } catch (IllegalArgumentException | TerminalInputException exception) {
                // Probably empty or invalid option clicked
            }

        });

        fillList();
    }

    private void fillList() {
        node.getItems().clear();

        terminalGui.getTerminal().getOptions().forEach((key, value) -> {
            if (!value.shouldList()) {
                return;
            }
            node.getItems().add(TerminalUtils.formatOptions(value));
        });

    }

    @Override
    public Node getNode() {
        return node;
    }

    @Override
    public void update() {
        fillList();
    }
}
