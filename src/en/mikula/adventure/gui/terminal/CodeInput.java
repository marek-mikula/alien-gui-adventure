package en.mikula.adventure.gui.terminal;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CodeInput {

    public static void enterCode(String correctCode, CodeInputCallback callback) {
        Stage codeStage = new Stage();
        codeStage.setTitle("Enter room code:");

        VBox vBox = new VBox();

        vBox.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
        vBox.setSpacing(10.0);

        TextField textField = new TextField();
        textField.setEditable(false);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(5.0);
        gridPane.setVgap(5.0);

        ColumnConstraints col = new ColumnConstraints();
        col.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(col, col, col);

        RowConstraints row = new RowConstraints();
        row.setVgrow(Priority.ALWAYS);

        gridPane.getRowConstraints().addAll(row, row, row);

        //     0   1   2
        //   +---+---+---+
        // 0 | 7 | 8 | 9 |
        //   +---+---+---+
        // 1 | 4 | 5 | 6 |
        //   +---+---+---+
        // 2 | 1 | 2 | 3 |
        //   +---+---+---+
        // 3 |   Enter   |
        //   +---+---+---+
        //
        // column cords (column, row)

        Button button1 = new Button("1");
        button1.setOnAction(event -> textField.setText(textField.getText() + "1"));
        gridPane.add(button1, 0, 2);

        GridPane.setFillWidth(button1, true);
        button1.setMaxWidth(Double.MAX_VALUE);

        Button button2 = new Button("2");
        button2.setOnAction(event -> textField.setText(textField.getText() + "2"));
        gridPane.add(button2, 1, 2);

        GridPane.setFillWidth(button2, true);
        button2.setMaxWidth(Double.MAX_VALUE);

        Button button3 = new Button("3");
        button3.setOnAction(event -> textField.setText(textField.getText() + "3"));
        gridPane.add(button3, 2, 2);

        GridPane.setFillWidth(button3, true);
        button3.setMaxWidth(Double.MAX_VALUE);

        Button button4 = new Button("4");
        button4.setOnAction(event -> textField.setText(textField.getText() + "4"));
        gridPane.add(button4, 0, 1);

        GridPane.setFillWidth(button4, true);
        button4.setMaxWidth(Double.MAX_VALUE);

        Button button5 = new Button("5");
        button5.setOnAction(event -> textField.setText(textField.getText() + "5"));
        gridPane.add(button5, 1, 1);

        GridPane.setFillWidth(button5, true);
        button5.setMaxWidth(Double.MAX_VALUE);

        Button button6 = new Button("6");
        button6.setOnAction(event -> textField.setText(textField.getText() + "6"));
        gridPane.add(button6, 2, 1);

        GridPane.setFillWidth(button6, true);
        button6.setMaxWidth(Double.MAX_VALUE);

        Button button7 = new Button("7");
        button7.setOnAction(event -> textField.setText(textField.getText() + "7"));
        gridPane.add(button7, 0, 0);

        GridPane.setFillWidth(button7, true);
        button7.setMaxWidth(Double.MAX_VALUE);

        Button button8 = new Button("8");
        button8.setOnAction(event -> textField.setText(textField.getText() + "8"));
        gridPane.add(button8, 1, 0);

        GridPane.setFillWidth(button8, true);
        button8.setMaxWidth(Double.MAX_VALUE);

        Button button9 = new Button("9");
        button9.setOnAction(event -> textField.setText(textField.getText() + "9"));
        gridPane.add(button9, 2, 0);

        GridPane.setFillWidth(button9, true);
        button9.setMaxWidth(Double.MAX_VALUE);

        Button buttonEnter = new Button("Enter");
        gridPane.add(buttonEnter, 0, 3, 3, 1);

        GridPane.setFillWidth(buttonEnter, true);
        buttonEnter.setMaxWidth(Double.MAX_VALUE);

        buttonEnter.setOnAction(event -> {
            codeStage.hide();

            if (textField.getText().equals(correctCode)) {
                callback.onSuccess();
            } else {
                callback.onFail();
            }
        });

        vBox.getChildren().add(textField);
        vBox.getChildren().add(gridPane);

        codeStage.setScene(new Scene(vBox));

        // Hook on close event
        codeStage.setOnCloseRequest(event -> {
            callback.onClose();
        });

        codeStage.showAndWait();
    }

}
