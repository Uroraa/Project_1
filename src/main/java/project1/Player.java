package project1;

import javafx.scene.Scene;
import javafx.scene.chart.*;
import java.util.List;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Player {
    Button back = new Button("Back");
    //Button detail = new Button("More...");
    public Scene getScene(){
        String filePath = "D:\\Desktop\\Prj 1\\Salah.csv";
        List<String[]> data = CSVReader.readCSV(filePath);

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Matches");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Goals and Assists");

        AreaChart<String, Number> areaChart = new AreaChart<>(xAxis, yAxis);
        areaChart.setTitle("Mohamed Salah's Performance");

        XYChart.Series<String, Number> goal = new XYChart.Series<>();
        XYChart.Series<String, Number> assist = new XYChart.Series<>();

        int goals = 0, assists = 0;

        for (int i = 1; i < data.size(); i++) {
            String match = data.get(i)[0];
            goals += Integer.parseInt(data.get(i)[1]);
            assists += Integer.parseInt(data.get(i)[2]);

            goal.getData().add(new XYChart.Data<>(match, goals));
            assist.getData().add(new XYChart.Data<>(match, assists));

        }

        areaChart.getData().addAll(goal, assist);
        areaChart.setLegendVisible(false);

        BorderPane root = new BorderPane();
        BorderPane bottom = new BorderPane();

        bottom.setLeft(back);
        //bottom.setRight(detail);

        root.setCenter(areaChart);
        root.setBottom(bottom);

        return new Scene(root, 800, 600);
    }
    public void setWelcomeButton(Runnable action){
        back.setOnAction(event -> action.run());
    }
}
