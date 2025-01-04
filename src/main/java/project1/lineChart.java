package project1;

import javafx.scene.Scene;
import javafx.scene.chart.*;
import java.util.List;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class lineChart {
    Button back = new Button("Back");
    Button detail = new Button("More details");

    public Scene getScene() {
        String filePath = "C:\\Users\\lenovo\\OneDrive\\Documents\\Liverpool.csv";
        List<String[]> data = CSVReader.readCSV(filePath);

        CategoryAxis xAxisLine = new CategoryAxis();
        xAxisLine.setLabel("Match");

        NumberAxis yAxisLine = new NumberAxis();
        yAxisLine.setLabel("Goals");

        LineChart<String, Number> lineChart = new LineChart<>(xAxisLine, yAxisLine);
        lineChart.setTitle("Goal and Goal Conceded Comparison");

        XYChart.Series<String, Number> seriesGoals = new XYChart.Series<>();
        seriesGoals.setName("Goals");

        XYChart.Series<String, Number> seriesConceded = new XYChart.Series<>();
        seriesConceded.setName("Goals Conceded");

        for (int i = 1; i < data.size(); i++) {
            String match = data.get(i)[0];
            int goals = Integer.parseInt(data.get(i)[2]);
            int goalsConceded = Integer.parseInt(data.get(i)[3]);

            seriesGoals.getData().add(new XYChart.Data<>(match, goals));
            seriesConceded.getData().add(new XYChart.Data<>(match, goalsConceded));
        }

        lineChart.getData().addAll(seriesGoals, seriesConceded);


        NumberAxis xAxisBubble = new NumberAxis();
        xAxisBubble.setLabel("Match Index");

        NumberAxis yAxisBubble = new NumberAxis();
        yAxisBubble.setLabel("Goals");

        BubbleChart<Number, Number> bubbleChart = new BubbleChart<>(xAxisBubble, yAxisBubble);
        bubbleChart.setTitle("Goals Difference (Bubble Size)");

        XYChart.Series<Number, Number> bubbleSeries = new XYChart.Series<>();
        bubbleSeries.setName("Goal Difference");

        for (int i = 1; i < data.size(); i++) {
            int matchIndex = i;
            int goals = Integer.parseInt(data.get(i)[2]);
            int goalsConceded = Integer.parseInt(data.get(i)[3]);
            int difference = Math.abs(goals - goalsConceded);

            XYChart.Data<Number, Number> bubble = new XYChart.Data<>(matchIndex, goals, difference);

            bubble.nodeProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    if (goalsConceded > goals) {
                        newValue.setStyle("-fx-border-color: red; -fx-border-width: 2px");
                    } else {
                        newValue.setStyle("-fx-border-color: green; -fx-border-width: 2px");
                    }
                }
            });

            bubbleSeries.getData().add(bubble);
        }

        bubbleChart.getData().add(bubbleSeries);

        VBox chartContainer = new VBox(lineChart, bubbleChart);

        BorderPane root = new BorderPane();
        BorderPane bottom = new BorderPane();

        bottom.setLeft(back);
        bottom.setRight(detail);

        root.setCenter(chartContainer);
        root.setBottom(bottom);

        return new Scene(root, 800, 600);
    }
    public void setBarButton(Runnable action){
        back.setOnAction(event -> action.run());
    }
    public void setLine2Button(Runnable action){
        detail.setOnAction(event -> action.run());
    }
}
