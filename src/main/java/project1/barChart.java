package project1;

import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.application.Platform;
import java.util.List;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class barChart {
    Button back = new Button("Back");

    Button detail = new Button("More details");

    public Scene getScene() {
        String filePath = "D:\\Desktop\\Prj 1\\Liverpool.csv";
        List<String[]> data = CSVReader.readCSV(filePath);

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Opponents");

        NumberAxis yAxis = new NumberAxis(-3, 3, 1);
        yAxis.setLabel("Recent games");

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Recent games");
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        //series.setName("Kết quả");

        for (int i = 1; i < data.size(); i++) {
            String team = data.get(i)[0];
            int res = Integer.parseInt(data.get(i)[1]);
            series.getData().add(new XYChart.Data<>(team, res));
        }

        barChart.getData().add(series);
        barChart.setLegendVisible(false);


        Platform.runLater(() -> {
            for (XYChart.Data<String, Number> data1 : series.getData()) {
                if (data1.getYValue().doubleValue() == 3) {
                    data1.getNode().setStyle("-fx-bar-fill: green;");
                } else if (data1.getYValue().doubleValue() == -3) {
                    data1.getNode().setStyle("-fx-bar-fill: red;");
                } else {
                    data1.getNode().setStyle("-fx-bar-fill: orange;");
                }
            }
        });


        CategoryAxis xAxis2 = new CategoryAxis();
        xAxis2.setLabel("Teams");

        NumberAxis yAxis2 = new NumberAxis();
        yAxis2.setLabel("Matches");

        StackedBarChart<String, Number> stackedBarChart = new StackedBarChart<>(xAxis2, yAxis2);
        stackedBarChart.setTitle("Liverpool Match History");

        XYChart.Series<String, Number> winsSeries = new XYChart.Series<>();
        winsSeries.setName("Wins");

        XYChart.Series<String, Number> drawsSeries = new XYChart.Series<>();
        drawsSeries.setName("Draws");

        XYChart.Series<String, Number> lossesSeries = new XYChart.Series<>();
        lossesSeries.setName("Losses");

        for (int i = 1; i < data.size(); i++) {
            String team = data.get(i)[0];
            int wins = Integer.parseInt(data.get(i)[6]);
            int draws = Integer.parseInt(data.get(i)[7]);
            int losses = Integer.parseInt(data.get(i)[8]);

            winsSeries.getData().add(new XYChart.Data<>(team, wins));
            drawsSeries.getData().add(new XYChart.Data<>(team, draws));
            lossesSeries.getData().add(new XYChart.Data<>(team, losses));
        }

        stackedBarChart.getData().addAll(lossesSeries, drawsSeries, winsSeries);

        VBox chartContainer = new VBox(barChart, stackedBarChart);

        BorderPane root = new BorderPane();
        BorderPane bottom = new BorderPane();

        bottom.setLeft(back);
        bottom.setRight(detail);

        root.setCenter(chartContainer);
        root.setBottom(bottom);

        return new Scene(root, 800, 600);
    }
    public void setWelcomeButton(Runnable action){
        back.setOnAction(event -> action.run());
    }
    public void setLineButton(Runnable action){
        detail.setOnAction(event -> action.run());
    }

}

