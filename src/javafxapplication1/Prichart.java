/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

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
import javafxapplication1.GanttChart.ExtraData;

/**
 *
 * @author YahyaShqair
 */
public class Prichart extends Application{
    
    @Override public void start(Stage stage) {

        stage.setTitle("Gantt Chart Priority with preemption and aging ");
        Priority rec=FXMLController.pri;
        rec.run();
        
        
        String[] proc = new String[FXMLController.arr.length];
        for(int i = 0 ; i < rec.arr.length; i ++ ){
            proc[i]="Process #"+rec.arr[i].PIC;
        }
        final NumberAxis xAxis = new NumberAxis();
        final CategoryAxis yAxis = new CategoryAxis();

        final GanttChart<Number,String> chart = new GanttChart<Number,String>(xAxis,yAxis);
        xAxis.setLabel("");
        xAxis.setTickLabelFill(Color.CHOCOLATE);
        xAxis.setMinorTickCount(4);

        yAxis.setLabel("");
        yAxis.setTickLabelFill(Color.CHOCOLATE);
        yAxis.setTickLabelGap(10);
        yAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(proc)));

        chart.setTitle("Priority with preemption and aging ");
        chart.setLegendVisible(false);
        chart.setBlockHeight( 50);
                        System.out.println(" yees"+proc.length+ " " );
         
        XYChart.Series serie[] = new XYChart.Series[proc.length];
        for(int i = 0 ; i < serie.length ; i ++ ){
            serie[i]=new XYChart.Series();
        }
        
        for(int i = 0 ; i < serie.length; i ++ ){// i indecate to process
            //(rec.arr[i].waitlist.get(ii)).getKey()
            //series1.getData().add(new XYChart.Data(0, machine, new ExtraData( 1, "status-red")));
            System.out.println(" yees"+proc.length+ " "+rec.arr[i].waitlist.size()+" " );
            for(int j = 0 ; j < rec.arr[i].waitlist.size();j++){//
            serie[i].getData().add(new XYChart.Data(rec.arr[i].waitlist.get(j).getKey(), proc[i], new ExtraData( rec.arr[i].waitlist.get(j).getValue()-rec.arr[i].waitlist.get(j).getKey(), "status-blue")));
            System.out.println(" "+rec.arr[i].waitlist.get(j).getKey()+" "+rec.arr[i].waitlist.get(j).getValue());
            }
            for(int j = 0 ; j < rec.arr[i].worklist.size();j++){//
            serie[i].getData().add(new XYChart.Data(rec.arr[i].worklist.get(j).getKey(), proc[i], new ExtraData( rec.arr[i].worklist.get(j).getValue()-rec.arr[i].worklist.get(j).getKey(), "status-green")));
            }
                
            }
            
            
            
            
            
            
            
            
            
            
            
            
        
        
        
        
        
        for(int i = 0 ; i < serie.length ; i ++){
            chart.getData().add(serie[i]);
        }
      
        chart.getStylesheets().add(getClass().getResource("robeen.css").toExternalForm());

        Scene scene  = new Scene(chart,620,350);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
