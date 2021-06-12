/*
 * Feel free to use anything : )  */
package javafxapplication1.view.controller;

import java.util.Arrays;

import javafx.application.Application;

import static javafx.application.Application.launch;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafxapplication1.service.impl.ShReFi;
import javafxapplication1.view.external.GanttChart;

/**
 * @author YahyaShqair
 */
public class Shortchart extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("Gantt Chart Shortest Remaining First");
        ShReFi rec = FXMLController.shor;
        rec.run();


        String[] proc = new String[FXMLController.arr.length];
        for (int i = 0; i < rec.processResultList.length; i++) {
            proc[i] = "Process #" + rec.processResultList[i].PIC;
        }
        final NumberAxis xAxis = new NumberAxis();
        final CategoryAxis yAxis = new CategoryAxis();

        final GanttChart<Number, String> chart = new GanttChart<Number, String>(xAxis, yAxis);
        xAxis.setLabel("");
        xAxis.setTickLabelFill(Color.CHOCOLATE);
        xAxis.setMinorTickCount(4);

        yAxis.setLabel("");
        yAxis.setTickLabelFill(Color.CHOCOLATE);
        yAxis.setTickLabelGap(10);
        yAxis.setCategories(FXCollections.observableArrayList(Arrays.asList(proc)));

        chart.setTitle("Shortest Remainding First");
        chart.setLegendVisible(false);
        chart.setBlockHeight(50);
        System.out.println(" yees" + proc.length + " ");

        XYChart.Series[] serie = new XYChart.Series[proc.length];
        for (int i = 0; i < serie.length; i++) {
            serie[i] = new XYChart.Series();
        }

        for (int i = 0; i < serie.length; i++) {// i indecate to process
            //(rec.arr[i].waitlist.get(ii)).getKey()
            //series1.getData().add(new XYChart.Data(0, machine, new ExtraData( 1, "status-red")));
            System.out.println(" yees" + proc.length + " " + rec.processResultList[i].waitingIntervals.size() + " ");
            for (int j = 0; j < rec.processResultList[i].waitingIntervals.size(); j++) {//
                serie[i].getData().add(new XYChart.Data(rec.processResultList[i].waitingIntervals.get(j).getKey(), proc[i], new GanttChart.ExtraData(rec.processResultList[i].waitingIntervals.get(j).getValue() - rec.processResultList[i].waitingIntervals.get(j).getKey(), "status-blue")));
                System.out.println(" " + rec.processResultList[i].waitingIntervals.get(j).getKey() + " " + rec.processResultList[i].waitingIntervals.get(j).getValue());
            }
            for (int j = 0; j < rec.processResultList[i].workingIntervals.size(); j++) {//
                serie[i].getData().add(new XYChart.Data(rec.processResultList[i].workingIntervals.get(j).getKey(), proc[i], new GanttChart.ExtraData(rec.processResultList[i].workingIntervals.get(j).getValue() - rec.processResultList[i].workingIntervals.get(j).getKey(), "status-green")));
            }

        }


        for (int i = 0; i < serie.length; i++) {
            chart.getData().add(serie[i]);
        }

        chart.getStylesheets().add(getClass().getResource("robeen.css").toExternalForm());

        Scene scene = new Scene(chart, 620, 350);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
