package project1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import java.util.List;

public class Table {
    Button back = new Button("Back");
    private final Scene scene;

    public Table(){
        String filePath = "D:\\Desktop\\Prj 1\\WC22\\WC 22.csv";
        List<String[]> rows = CSVReader.readCSV(filePath);

        TableView<ObservableList<String>> tableView = new TableView<>();

        if (!rows.isEmpty()) {
            String[] headers = rows.get(0);

            for (int i = 0; i < headers.length; i++) {
                final int colIndex = i;
                TableColumn<ObservableList<String>, String> column = new TableColumn<>(headers[i]);

                column.setCellValueFactory(param -> {
                    if (param.getValue().size() > colIndex) {
                        return new javafx.beans.property.SimpleStringProperty(param.getValue().get(colIndex));
                    }
                    return null;
                });

                tableView.getColumns().add(column);
            }

            ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

            for (int i = 1; i < rows.size(); i++) {
                ObservableList<String> row = FXCollections.observableArrayList(rows.get(i));
                data.add(row);
            }
            tableView.setItems(data);
        }

        BorderPane root = new BorderPane();
        BorderPane bottom = new BorderPane();
        //VBox table = new VBox(tableView);

        bottom.setLeft(back);

        root.setCenter(tableView);
        root.setBottom(bottom);

        this.scene = new Scene(root, 800, 600);
    }
    public Scene getScene() {
        return scene;
    }
    public void setWelcomeButton(Runnable action){
        back.setOnAction(event -> action.run());
    }

}

