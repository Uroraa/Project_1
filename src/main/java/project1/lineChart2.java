package project1;

import javafx.scene.Scene;
import javafx.scene.chart.*;
import java.util.List;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

public class lineChart2 {
    Button back = new Button("Back");
    public Scene getScene(){
        String filePath = "C:\\Users\\lenovo\\OneDrive\\Documents\\Liverpool.csv";
        List<String[]> data = CSVReader.readCSV(filePath);

        CategoryAxis xAxis = new CategoryAxis();
        //xAxis.setLabel("Team");

        NumberAxis yAxis = new NumberAxis(-10, 10, 1);
        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);


        lineChart.setCreateSymbols(true);
        lineChart.setTitle("Number of yellow and red card");

        XYChart.Series<String, Number> series3 = new XYChart.Series<>();
        series3.setName("Yellow Card");
        XYChart.Series<String, Number> series4 = new XYChart.Series<>();
        series4.setName("Red Card");

        for(int i = 1; i < data.size(); i++){
            String team = data.get(i)[0];
            int yellow = Integer.parseInt(data.get(i)[4]);
            int red = Integer.parseInt(data.get(i)[5]);
            series3.getData().add(new XYChart.Data<>(team, yellow));
            series4.getData().add(new XYChart.Data<>(team, red));
        }

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
    }}
