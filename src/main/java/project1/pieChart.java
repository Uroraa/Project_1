package project1;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import java.util.List;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
public class pieChart {
    Button back = new Button("Back");
    Button home = new Button("Home");
    public Scene getScene(){
        String filePath = "D:\\Desktop\\Prj 1\\Liverpool.csv";
        List<String[]> data = CSVReader.readCSV(filePath);

        int wins = 0;
        int draws = 0;
        int losses = 0;

        for (int i = 1; i < data.size(); i++) {
            String result = data.get(i)[1];
            switch (result) {
                case "3":
                    wins++;
                    break;
                case "1":
                    draws++;
                    break;
                case "-3":
                    losses++;
                    break;
                default:
                    System.out.println("Unknown result: " + result);
            }
        }

        int total = wins + draws + losses;

        PieChart pieChart = new PieChart();
        pieChart.getData().add(new PieChart.Data(String.format("Losses: " + "%.1f%%", (losses * 100.0) / total), losses));
        pieChart.getData().add(new PieChart.Data(String.format("Draws: " + "%.1f%%", (draws * 100.0) / total), draws));
        pieChart.getData().add(new PieChart.Data(String.format("Win: " + "%.1f%%", (wins * 100.0) / total), wins));
        pieChart.setTitle("Match Results");
        pieChart.setLegendVisible(false);

        BorderPane root = new BorderPane();
        BorderPane bottom = new BorderPane();
        bottom.setLeft(back);
        bottom.setRight(home);

        root.setCenter(pieChart);
        root.setBottom(bottom);

        return new Scene(root, 800, 600);
    }
    public void setLine2Button(Runnable action){
        back.setOnAction(event -> action.run());
    }

    public void setWelcomeButton(Runnable action){
        home.setOnAction(event -> action.run());
    }
}
