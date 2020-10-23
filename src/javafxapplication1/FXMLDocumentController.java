
package javafxapplication1;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Pair;


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
        Parent gotonew = FXMLLoader.load(getClass().getResource("FXML.fxml"));
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
