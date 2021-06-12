
package javafxapplication1.view.controller;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;


/**
 *
 * @author YahyaShqair
 */
public class FXMLDocumentController implements Initializable {
   
    @FXML
    private Button buttnext;
    
    @FXML
    private ImageView power;

    @FXML
    private ImageView pic;
    static FileChooser fc ;
    static File f;
    @FXML
    private void handlepic(MouseEvent event) {
         fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Text Files","*.txt"));
         f = fc.showOpenDialog(null);
        if(f!=null){
        buttnext.disableProperty().set(false);
        }
    }
    
    @FXML
    private void handlechange(ActionEvent event) throws IOException {
        Parent gotonew = FXMLLoader.load(getClass().getResource("fxml/FXML.fxml"));
        Scene go = new Scene(gotonew);
        Stage current = (Stage)((Node)event.getSource()).getScene().getWindow();
        current.setScene(go);
    }
    @FXML
    private void handlepower(MouseEvent event) {
        Stage current = (Stage)((Node)event.getSource()).getScene().getWindow();
        current.hide();
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
    }    
    
}
