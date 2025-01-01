package project1;

import javafx.scene.Scene;
import javafx.scene.chart.*;
import java.util.List;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

public class lineChart {
    Button back = new Button("Back");
    Button detail = new Button("More details");

    public Scene getScene(){
        String filePath = "C:\\Users\\lenovo\\OneDrive\\Documents\\Liverpool.csv";
        List<String[]> data = CSVReader.readCSV(filePath);

        CategoryAxis xAxis = new CategoryAxis();
        //xAxis.setLabel("Team");

        NumberAxis yAxis = new NumberAxis(-10, 10, 1);
        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);


        lineChart.setCreateSymbols(true);
        lineChart.setTitle("Goal and goal conceded");

        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Goal");
        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Goal Conceded");


        for(int i = 1; i < data.size(); i++) {
            String team = data.get(i)[0];
            int goal = Integer.parseInt(data.get(i)[2]);
            int goalConceded = Integer.parseInt(data.get(i)[3]);

            series1.getData().add(new XYChart.Data<>(team, goal));
            series2.getData().add(new XYChart.Data<>(team, goalConceded));
        }

        lineChart.getData().add(series1);
        lineChart.getData().add(series2);


        BorderPane root = new BorderPane();
        BorderPane bottom = new BorderPane();

        bottom.setLeft(back);
        bottom.setRight(detail);

        root.setCenter(lineChart);
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
