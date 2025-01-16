package project1;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.image.Image;

public class Welcome {
    Scene scene;
    Button tableButton, chartButton, player;
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

        label = new Label("Footbal Statics");
        label.setStyle(" -fx-font-size: 40px; -fx-text-fill: red");

        tableButton = new Button("Schedule");
        tableButton.setStyle("-fx-background-color: orange");
        tableButton.setPrefWidth(150);
        tableButton.setPrefHeight(50);

        chartButton = new Button("Liverpool's performance");
        chartButton.setStyle("-fx-background-color: orange");
        chartButton.setPrefWidth(150);
        chartButton.setPrefHeight(50);

        player = new Button("Player's performance");
        player.setStyle("-fx-background-color: orange");
        player.setPrefWidth(150);
        player.setPrefHeight(50);

        gridPane.add(label, 2, 0, 10, 3);
        gridPane.add(tableButton, 0, 4, 2, 1);
        gridPane.add(chartButton, 0, 5, 2, 1);
        gridPane.add(player, 0, 6, 2, 1);

        GridPane.setHalignment(label, HPos.RIGHT);
        GridPane.setHalignment(tableButton, HPos.CENTER);
        GridPane.setHalignment(chartButton, HPos.CENTER);
        GridPane.setHalignment(player, HPos.CENTER);

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
    public void setPlayerButton(Runnable action){
        player.setOnAction(event -> action.run());
    }
}
