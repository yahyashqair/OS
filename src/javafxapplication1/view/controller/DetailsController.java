/*
  * Feel free to use anything : )  */
package javafxapplication1.view.controller;

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
import javafxapplication1.service.ProcessInWork;

/**
 * FXML Controller class
 *
 * @author YahyaShqair
 */
public class DetailsController implements Initializable {

    @FXML
    private TableView<ProcessInWork> table;

    @FXML
    private TableColumn<ProcessInWork, Integer> pid;

    @FXML
    private TableColumn<ProcessInWork, Integer> bt;

    @FXML
    private TableColumn<ProcessInWork, Integer> wt;

    @FXML
    private TableColumn<ProcessInWork, Integer> tat;

    @FXML
    private Button back;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<ProcessInWork> peo = FXCollections.observableArrayList();
       if(FXMLController.who==0){
        for (int i = 0; i < FXMLController.rb.processResultList.length; i++) {
                peo.add(FXMLController.rb.processResultList[i]);
        }}
        if(FXMLController.who==1){
        for (int i = 0; i < FXMLController.pri.processResultList.length; i++) {
                peo.add(FXMLController.pri.processResultList[i]);
        }}
        if(FXMLController.who==2){
        for (int i = 0; i < FXMLController.shor.processResultList.length; i++) {
                peo.add(FXMLController.shor.processResultList[i]);
        }}
        if(FXMLController.who==3){
        for (int i = 0; i < FXMLController.fc.processResultList.length; i++) {
                peo.add(FXMLController.fc.processResultList[i]);
        }}
        if(FXMLController.who==4){
        for (int i = 0; i < FXMLController.lc.processResultList.length; i++) {
                peo.add(FXMLController.lc.processResultList[i]);
        }}
        

        /*
     int remain;
     int turnaround;
     int waiting;
     int runn;*/        

        pid.setCellValueFactory(new PropertyValueFactory<ProcessInWork, Integer>("PIC"));
        wt.setCellValueFactory(new PropertyValueFactory<ProcessInWork, Integer>("waiting"));
        bt.setCellValueFactory(new PropertyValueFactory<ProcessInWork, Integer>("BurstTime"));
        tat.setCellValueFactory(new PropertyValueFactory<ProcessInWork, Integer>("turnaround"));//waiting

        table.setItems(peo); 
    }    
    
    @FXML
    private void handlechange(ActionEvent event) throws IOException {
        Parent gotonew = FXMLLoader.load(getClass().getResource("fxml/FXML.fxml"));
        Scene go = new Scene(gotonew);
        Stage current = (Stage)((Node)event.getSource()).getScene().getWindow();
        current.setScene(go);
    }
}
