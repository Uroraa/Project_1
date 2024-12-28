package project1;

import javafx.scene.Scene;
import javafx.scene.chart.*;
import java.util.List;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

public class lineChart {
    Button back = new Button("Quay lại");
    public Scene getScene(){
        String filePath = "C:\\Users\\lenovo\\OneDrive\\Documents\\Liverpool.csv";
        List<String[]> data = CSVReader.readCSV(filePath);

        CategoryAxis xAxis = new CategoryAxis();
        //xAxis.setLabel("Team");

        NumberAxis yAxis = new NumberAxis(-10, 10, 1);
        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);


        lineChart.setCreateSymbols(true);
        lineChart.setTitle("Bàn thắng/thua và sổ thẻ đỏ/vàng");

        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Goal");
        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Goal Conceded");
        XYChart.Series<String, Number> series3 = new XYChart.Series<>();
        series3.setName("Yellow Card");
        XYChart.Series<String, Number> series4 = new XYChart.Series<>();
        series4.setName("Red Card");

        for(int i = 1; i < data.size(); i++){
            String team = data.get(i)[0];
            int goal = Integer.parseInt(data.get(i)[2]);
            int goalConceded = Integer.parseInt(data.get(i)[3]);
            int yellow = Integer.parseInt(data.get(i)[4]);
            int red = Integer.parseInt(data.get(i)[5]);
            series1.getData().add(new XYChart.Data<>(team, goal));
            series2.getData().add(new XYChart.Data<>(team, goalConceded));
            series3.getData().add(new XYChart.Data<>(team, yellow));
            series4.getData().add(new XYChart.Data<>(team, red));
        }

        lineChart.getData().add(series1);
        lineChart.getData().add(series2);
        lineChart.getData().add(series3);
        lineChart.getData().add(series4);

        BorderPane root = new BorderPane();
        BorderPane bottom = new BorderPane();

        bottom.setLeft(back);

        root.setCenter(lineChart);
        root.setBottom(bottom);

        return new Scene(root, 800, 600);
    }
    public void setBarButton(Runnable action){
        back.setOnAction(event -> action.run());
    }
}
