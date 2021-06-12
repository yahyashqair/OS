package javafxapplication1.view.controller;

import java.util.Arrays;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafxapplication1.view.external.GanttChart;
import javafxapplication1.view.external.GanttChart.ExtraData;
import javafxapplication1.service.Algorithm;

// TODO: use date for x-axis
public class allThreads extends Application implements Runnable {

    Stage stage;
    int idx; // 0 rr // 1 pri // 2 shrf // 3 fcfs // 4 lcfs
    Algorithm rec;

    @Override
    public void start(Stage stage) {

        stage.setTitle(Thread.currentThread().getName());
        if (idx == 0) {
            rec = FXMLController.rb;
            rec.run();

        } else if (idx == 1) {
            rec = FXMLController.pri;
            rec.run();
        } else if (idx == 2) {

        } else if (idx == 3) {
            rec = FXMLController.fc;
            rec.run();
        } else if (idx == 4) {
            rec = FXMLController.lc;
            rec.run();
        }
        for (int i = 0; i < rec.processResultList.length; i++) {
            for (int j = 0; j < rec.processResultList[i].workingIntervals.size(); j++) {
                System.out.println(rec.processResultList[i].PIC + "==  work from  " + rec.processResultList[i].workingIntervals.get(j).getKey() + " to " + rec.processResultList[i].workingIntervals.get(j).getValue());
            }
        }
        String[] proc = new String[rec.processResultList.length];
        for (int i = 0; i < rec.processResultList.length; i++) {
            proc[i] = "Process #" + rec.processResultList[i].PIC;
        }
        System.out.println("ENTERTHREADS");
        final NumberAxis xAxis = new NumberAxis();
        final CategoryAxis yAxis = new CategoryAxis();

        final GanttChart<Number, String> chart = new GanttChart<Number, String>(xAxis, yAxis);
        if (idx == 0) {
            chart.setTitle("Round Roben");
        } else if (idx == 1) {
            chart.setTitle("Priority with aging");
        } else if (idx == 2) {
        } else if (idx == 3) {
            chart.setTitle("First come first serve");
        } else if (idx == 4) {
            chart.setTitle("Last come First serve");
        }
        xAxis.setLabel("");
        xAxis.setTickLabelFill(Color.CHOCOLATE);
        xAxis.setMinorTickCount(4);

        yAxis.setLabel("");
        yAxis.setTickLabelFill(Color.CHOCOLATE);
        yAxis.setTickLabelGap(10);
        yAxis.setCategories(FXCollections.observableArrayList(Arrays.asList(proc)));
        chart.setLegendVisible(false);
        chart.setBlockHeight(50);
        System.out.println(" yees" + proc.length + " ");
        XYChart.Series[] serie = new XYChart.Series[proc.length];
        for (int i = 0; i < serie.length; i++) {
            serie[i] = new XYChart.Series();
        }

        for (int i = 0; i < rec.processResultList.length; i++) {
            for (int j = 0; j < rec.processResultList[i].workingIntervals.size(); j++) {
                System.out.println(rec.processResultList[i].PIC + "==  work from  " + rec.processResultList[i].workingIntervals.get(j).getKey() + " to " + rec.processResultList[i].workingIntervals.get(j).getValue());
            }
        }


        for (int i = 0; i < serie.length; i++) {// i indecate to process
            //(rec.arr[i].waitlist.get(ii)).getKey()
            //series1.getData().add(new XYChart.Data(0, machine, new ExtraData( 1, "status-red")));
            System.out.println(" yees" + proc.length + " " + rec.processResultList[i].waitingIntervals.size() + " ");
            for (int j = 0; j < rec.processResultList[i].waitingIntervals.size(); j++) {//
                serie[i].getData().add(new XYChart.Data(rec.processResultList[i].waitingIntervals.get(j).getKey(), proc[i], new ExtraData(rec.processResultList[i].waitingIntervals.get(j).getValue() - rec.processResultList[i].waitingIntervals.get(j).getKey(), "status-blue")));
                System.out.println(" " + rec.processResultList[i].waitingIntervals.get(j).getKey() + " " + rec.processResultList[i].waitingIntervals.get(j).getValue());
            }
            for (int j = 0; j < rec.processResultList[i].workingIntervals.size(); j++) {//
                serie[i].getData().add(new XYChart.Data(rec.processResultList[i].workingIntervals.get(j).getKey(), proc[i], new ExtraData(rec.processResultList[i].workingIntervals.get(j).getValue() - rec.processResultList[i].workingIntervals.get(j).getKey(), "status-green")));
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

    public allThreads(int i) {
        this.idx = i;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void run() {
        //this.start(new Stage());
    }
}
