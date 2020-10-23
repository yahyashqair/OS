/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafxapplication1.GanttChart.ExtraData;

/**
 * FXML Controller class
 *
 * @author YahyaShqair
 */
public class FXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    static lcfs lc;
    static Fcfs fc;
    static Roben rb;
    static Priority pri;
    static ShReFi shor;
    static int who=0;//
    @FXML
    private Button round;

    @FXML
    private TextField timelimit;

    @FXML
    private AnchorPane pain;
    
    @FXML
    private Button Pro;
    @FXML
    private Button srf;

    @FXML
    private Button ra;

    @FXML
    private Button sa;

    @FXML
    private Button na;

    @FXML
    private TextField roben;
    
    @FXML
    private Button add;

    @FXML
    private Button sjf;

    @FXML
    private Button fcfs;

    @FXML
    private Button lcfs;

    @FXML
    private TableView<Process> processtable;

    @FXML
    private TableColumn<Process, Integer> pid;

    @FXML
    private TableColumn<Process, Integer> art;

    @FXML
    private TableColumn<Process, Integer> bt;

    @FXML
    private TableColumn<Process, Integer> dl;
    File f1;
    static Process arr[];
    static ArrayList<Process> ar;
    @FXML
    private void handlechange(ActionEvent event) throws IOException {
        Parent gotonew = FXMLLoader.load(getClass().getResource("details.fxml"));
        Scene go = new Scene(gotonew);
        Stage current = (Stage)((Node)event.getSource()).getScene().getWindow();
        current.setScene(go);
    }
    @FXML
    void addrandom(){// function for add randome value 
        Random rand = new Random();
        Process p1=new Process(Process.PICC,rand.nextInt(10)+1,rand.nextInt(10)+1,rand.nextInt(10)+1);
        ar.add(p1);
        arr=null;
        arr = new Process[ar.size()];
        arr = (Process[]) ar.toArray(arr);
        refresh();
    }
    void refresh(){// for update table after adding randome value
        ObservableList<Process> people = FXCollections.observableArrayList();
        for (int i = 0; i < arr.length; i++) {
            people.add(arr[i]);
        }
        processtable.setItems(people);
        
    }
    public void initprocess() throws FileNotFoundException {
        f1 = FXMLDocumentController.f;
        String x;
         ar = new ArrayList<Process>();
        Scanner re = new Scanner(f1);
        while (re.hasNext()) {
            int pic = re.nextInt();
            int art = re.nextInt();
            int bt = re.nextInt();
            int dt = re.nextInt();
            ar.add(new Process(pic, art, bt, dt));
        }
        arr = new Process[ar.size()];
        arr = (Process[]) ar.toArray(arr);

        ObservableList<Process> people = FXCollections.observableArrayList();
        for (int i = 0; i < arr.length; i++) {
            people.add(arr[i]);
        }
        pid.setCellValueFactory(new PropertyValueFactory<Process, Integer>("PIC"));
        art.setCellValueFactory(new PropertyValueFactory<Process, Integer>("AraivalTime"));
        bt.setCellValueFactory(new PropertyValueFactory<Process, Integer>("BurstTime"));
        dl.setCellValueFactory(new PropertyValueFactory<Process, Integer>("Deadline"));

        processtable.setItems(people);
    }
    // round roben algorethem 
    @FXML
    void rrb(ActionEvent event) throws IOException {
       
        int rocont = new Integer(roben.getText().toString());
        int time= new Integer(timelimit.getText().toString());
        rb = new Roben(arr, rocont,time);
        who=0;
        Roundchart rond = new Roundchart();
        rond.start(new Stage());
                FXMLLoader gotonew = new FXMLLoader(getClass().getResource("details.fxml"));

        //FXMLLoader  gotonew = FXMLLoader.load(getClass().getResource("details.fxml"));
                Parent root1 = (Parent) gotonew.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
    }
    
    @FXML
    void fcfs(ActionEvent event) throws IOException {
               int time= new Integer(timelimit.getText().toString());
        fc= new Fcfs(arr,time);
        who=3;
        fc.run();
        allThreads fcf = new allThreads(3);
        fcf.start(new Stage());
//        Parent gotonew = FXMLLoader.load(getClass().getResource("details.fxml"));
//        Scene go = new Scene(gotonew);
//        Stage current = (Stage)((Node)event.getSource()).getScene().getWindow();
//        current.setScene(go);
                FXMLLoader gotonew = new FXMLLoader(getClass().getResource("details.fxml"));
                Parent root1 = (Parent) gotonew.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
    }
    
    @FXML
    void lcfs(ActionEvent event) throws IOException {
               int time= new Integer(timelimit.getText().toString());
        lc= new lcfs(arr,time);
        lc.run();
        who=4;
        allThreads fcf = new allThreads(4);
        fcf.start(new Stage());
//        Parent gotonew = FXMLLoader.load(getClass().getResource("details.fxml"));
//        Scene go = new Scene(gotonew);
//        Stage current = (Stage)((Node)event.getSource()).getScene().getWindow();
//        current.setScene(go);
 FXMLLoader gotonew = new FXMLLoader(getClass().getResource("details.fxml"));
                Parent root1 = (Parent) gotonew.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
    }


    @FXML
    void Threaduse() { // using threads 
        int rocont = new Integer(roben.getText().toString());
        int time= new Integer(timelimit.getText().toString());

        rb = new Roben(arr, rocont,time);
        allThreads a1 = new allThreads(0);
        pri = new Priority(arr,time);
        allThreads a2 = new allThreads(1);
       Thread rob=new Thread(a1);
       Thread ro=new Thread (a2);
       
        new Thread(() -> {
            Platform.runLater(() -> {
                a1.start(new Stage());
            });
        }).start();
        new Thread(() -> {
            Platform.runLater(() -> {
                a2.start(new Stage());
            });
        }).start();

    }

    @FXML
    void prio(ActionEvent event) throws IOException { // priority function 
        
        int time= new Integer(timelimit.getText().toString());
        pri = new Priority(arr,time);
        Prichart rond = new Prichart();
        rond.start(new Stage());
        who = 1 ; 
            for (int i = 0; i < arr.length; i++) {
           for (int j = 0; j < pri.arr[i].worklist.size(); j++) {
               System.out.println(pri.arr[i].PIC+"==  work from  "+pri.arr[i].worklist.get(j).getKey()+" to "+pri.arr[i].worklist.get(j).getValue());
           } 
        }
                FXMLLoader gotonew = new FXMLLoader(getClass().getResource("details.fxml"));
                Parent root1 = (Parent) gotonew.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
    }

    @FXML
    void Shrotest(ActionEvent event) throws IOException { // shortesr job function 
        int time= new Integer(timelimit.getText().toString());
        shor = new ShReFi(arr,time);
        shor.run();
        who = 2; 
        Shortchart rond = new Shortchart();
        rond.start(new Stage());
        
                FXMLLoader gotonew = new FXMLLoader(getClass().getResource("details.fxml"));
                Parent root1 = (Parent) gotonew.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        try {
            roben.setText("1");
            timelimit.setText("100");

            initprocess();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
