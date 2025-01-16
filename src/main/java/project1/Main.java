package project1;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
    public void start(Stage primaryStage){

        Welcome welcome = new Welcome();
        barChart bar = new barChart();
        Table table = new Table();
        lineChart line1 = new lineChart();
        lineChart2 line2 = new lineChart2();
        pieChart pie = new pieChart();

        Player player = new Player();

        primaryStage.setTitle("Welcome");
        primaryStage.setScene(welcome.getScene());
        primaryStage.show();


        welcome.setChartButton(() -> primaryStage.setScene(bar.getScene()));
        welcome.setTableButton(() -> primaryStage.setScene(table.getScene()));
        welcome.setPlayerButton(() -> primaryStage.setScene(player.getScene()));

        table.setWelcomeButton(() -> primaryStage.setScene(welcome.getScene()));

        bar.setWelcomeButton(() -> primaryStage.setScene(welcome.getScene()));
        bar.setLineButton(() -> primaryStage.setScene(line1.getScene()));

        player.setWelcomeButton(() -> primaryStage.setScene(welcome.getScene()));

        line1.setBarButton(() -> primaryStage.setScene(bar.getScene()));
        line1.setLine2Button(() -> primaryStage.setScene(line2.getScene()));

        line2.setLineButton(() -> primaryStage.setScene(line1.getScene()));
        line2.setPieButton(() -> primaryStage.setScene(pie.getScene()));

        pie.setLine2Button(() -> primaryStage.setScene(line2.getScene()));
        pie.setWelcomeButton(() -> primaryStage.setScene(welcome.getScene()));


    }

    public static void main(String[] args){
        launch(args);
    }
}
