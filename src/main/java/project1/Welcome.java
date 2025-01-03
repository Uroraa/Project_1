package project1;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.image.Image;

public class Welcome {
    private final Scene scene;
    private final Button tableButton, chartButton;
    Label label;

    public Welcome(){
        Image img = new Image("file:\\D:\\Download\\Szoboszlai-Liverpool.jpg");
        BackgroundImage backgrd = new BackgroundImage(
                img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, false, false, true, false)
                );

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(25);
        gridPane.setVgap(15);
        gridPane.setBackground(new Background(backgrd));

        label = new Label("Chương Trình Thống Kê");
        label.setStyle(" -fx-font-size: 40px; -fx-text-fill: red");

        tableButton = new Button("Lịch thi đấu");
        tableButton.setStyle("-fx-background-color: orange");
        tableButton.setPrefWidth(150);
        tableButton.setPrefHeight(50);

        chartButton = new Button("Phong độ của đội");
        chartButton.setStyle("-fx-background-color: orange");
        chartButton.setPrefWidth(150);
        chartButton.setPrefHeight(50);

        gridPane.add(label, 2, 0, 10, 3);
        gridPane.add(tableButton, 0, 4, 2, 1);
        gridPane.add(chartButton, 0, 5, 2, 1);

        GridPane.setHalignment(label, HPos.RIGHT);
        GridPane.setHalignment(tableButton, HPos.CENTER);
        GridPane.setHalignment(chartButton, HPos.CENTER);

        this.scene = new Scene(gridPane, 800, 600);

    }
    public Scene getScene() {
        return scene;
    }
    public void setChartButton(Runnable action){
        chartButton.setOnAction(event -> action.run());
    }
    public void setTableButton(Runnable action){
        tableButton.setOnAction(event -> action.run());
    }
}
