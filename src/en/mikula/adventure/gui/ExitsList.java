package en.mikula.adventure.gui;

import en.mikula.adventure.commands.Command;
import en.mikula.adventure.rooms.Room;
import en.mikula.adventure.utils.Observer;
import en.mikula.adventure.utils.RoomUtils;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TitledPane;

public class ExitsList implements LayoutPart, Observer {

    private final Gui gui;

    private final TitledPane node = new TitledPane();

    private final ListView<String> listView = new ListView<>();

    public ExitsList(Gui gui) {
        this.gui = gui;
        initNode();
    }

    private void initNode() {
        node.setContent(listView);
        node.setMaxHeight(200.0);

        // Set selection mode to single
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        // Allow user to change the room by clicking on list item
        listView.setOnMouseClicked(event -> {
            String text = listView.getSelectionModel().getSelectedItem();

            if (text == null) {
                return;
            }

            int roomNumber;
            try {
                roomNumber = RoomUtils.extractRoomNumber(text);
            } catch (IllegalArgumentException exception) {
                // Probably empty or invalid option clicked
                return;
            }

            Command goCommand = gui.getGame().getCommandReader().getCommandParser().getCommandList().getCommand("go");

            String result = goCommand.run(roomNumber + "");

            gui.getOutput().write(result);
        });

        fillList();
        updateTitle();
    }

    private void fillList() {
        // Clear the items in the flow pane first
        listView.getItems().clear();

        gui.getGame().getMap().getCurrentRoom().getConnections().forEach(roomConnection -> {
            listView.getItems().add(RoomUtils.formatName(roomConnection.getNext()));
        });
    }

    private void updateTitle() {
        Room currentRoom = gui.getGame().getMap().getCurrentRoom();
        node.setText("Exits - " + RoomUtils.formatName(currentRoom));
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
