package project1;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
    public void start(Stage primaryStage){

        Welcome welcome = new Welcome();
        barChart chart1 = new barChart();
        Table table = new Table();
        lineChart chart2 = new lineChart();
        lineChart2 chart3 = new lineChart2();


        primaryStage.setTitle("Hello Stage");
        primaryStage.setScene(welcome.getScene());
        primaryStage.show();


        welcome.setChartButton(() -> primaryStage.setScene(chart1.getScene()));
        welcome.setTableButton(() -> primaryStage.setScene(table.getScene()));

        chart1.setWelcomeButton(() -> primaryStage.setScene(welcome.getScene()));
        chart1.setLineButton(() -> primaryStage.setScene(chart2.getScene()));

        chart2.setBarButton(() -> primaryStage.setScene(chart1.getScene()));
        chart2.setLine2Button(() -> primaryStage.setScene(chart3.getScene()));

        chart3.setBarButton(() -> primaryStage.setScene(chart1.getScene()));

        table.setWelcomeButton(() -> primaryStage.setScene(welcome.getScene()));

    }

    public static void main(String[] args){
        launch(args);
    }
}
