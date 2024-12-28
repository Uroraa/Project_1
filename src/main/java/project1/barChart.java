package project1;

import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.application.Platform;
import java.util.List;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;

public class barChart {
    Button back = new Button("Quay lại");

    Button detail = new Button("Chi tiết");

    public Scene getScene() {
        String filePath = "C:\\Users\\lenovo\\OneDrive\\Documents\\Liverpool.csv";
        List<String[]> data = CSVReader.readCSV(filePath);

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Đối thủ");

        NumberAxis yAxis = new NumberAxis(-3, 3, 1);
        yAxis.setLabel("Phong độ thắng/thua");

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        //series.setName("Kết quả");

        for (int i = 1; i < data.size(); i++) {
            String team = data.get(i)[0];
            int res = Integer.parseInt(data.get(i)[1]);
            series.getData().add(new XYChart.Data<>(team, res));
        }

        barChart.getData().add(series);
        barChart.setLegendVisible(false);


        BorderPane root = new BorderPane();
        BorderPane bottom = new BorderPane();

        bottom.setLeft(back);
        bottom.setRight(detail);
        root.setCenter(barChart);
        root.setBottom(bottom);

        Platform.runLater(() -> {
            for (XYChart.Data<String, Number> data1 : series.getData()) {
                if (data1.getYValue().doubleValue() == 3) {
                    data1.getNode().setStyle("-fx-bar-fill: green;");
                } else if (data1.getYValue().doubleValue() == -3) {
                    data1.getNode().setStyle("-fx-bar-fill: red;");
                } else {
                    data1.getNode().setStyle("-fx-bar-fill: grey;");
                }
            }
        });

        return new Scene(root, 800, 600);
    }
    public void setWelcomeButton1(Runnable action){
        back.setOnAction(event -> action.run());
    }
    public void setLineButton(Runnable action){
        detail.setOnAction(event -> action.run());
    }

}

