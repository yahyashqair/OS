/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static javafxapplication1.FXMLController.arr;

/**
 * FXML Controller class
 *
 * @author YahyaShqair
 */
public class DetailsController implements Initializable {

    @FXML
    private TableView<processInWork> table;

    @FXML
    private TableColumn<processInWork, Integer> pid;

    @FXML
    private TableColumn<processInWork, Integer> bt;

    @FXML
    private TableColumn<processInWork, Integer> wt;

    @FXML
    private TableColumn<processInWork, Integer> tat;

    @FXML
    private Button back;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<processInWork> peo = FXCollections.observableArrayList();
       if(FXMLController.who==0){
        for (int i = 0; i < FXMLController.rb.arr.length; i++) {
                peo.add(FXMLController.rb.arr[i]);
        }}
        if(FXMLController.who==1){
        for (int i = 0; i < FXMLController.pri.arr.length; i++) {
                peo.add(FXMLController.pri.arr[i]);
        }}
        if(FXMLController.who==2){
        for (int i = 0; i < FXMLController.shor.arr.length; i++) {
                peo.add(FXMLController.shor.arr[i]);
        }}
        if(FXMLController.who==3){
        for (int i = 0; i < FXMLController.fc.arr.length; i++) {
                peo.add(FXMLController.fc.arr[i]);
        }}
        if(FXMLController.who==4){
        for (int i = 0; i < FXMLController.lc.arr.length; i++) {
                peo.add(FXMLController.lc.arr[i]);
        }}
        

        /*
     int remain;
     int turnaround;
     int waiting;
     int runn;*/        

        pid.setCellValueFactory(new PropertyValueFactory<processInWork, Integer>("PIC"));
        wt.setCellValueFactory(new PropertyValueFactory<processInWork, Integer>("waiting"));
        bt.setCellValueFactory(new PropertyValueFactory<processInWork, Integer>("BurstTime"));
        tat.setCellValueFactory(new PropertyValueFactory<processInWork, Integer>("turnaround"));//waiting

        table.setItems(peo); 
    }    
    
    @FXML
    private void handlechange(ActionEvent event) throws IOException {
        Parent gotonew = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Scene go = new Scene(gotonew);
        Stage current = (Stage)((Node)event.getSource()).getScene().getWindow();
        current.setScene(go);
    }
}
