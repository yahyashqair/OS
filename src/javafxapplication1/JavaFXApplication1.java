/*
 * Feel free to use anything : )  */
package javafxapplication1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafxapplication1.service.impl.Priority;
import javafxapplication1.service.Process;
import javafxapplication1.service.impl.Roben;

/**
 * @author YahyaShqair
 */
public class JavaFXApplication1 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/fxml/FXMLDocument.fxml"));
        testAlgorithms();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method will describe how to use the simulator without UI.
     */
    private void testAlgorithms() {
        System.out.println("javafxapplication1.JavaFXApplication1.start()");
        // stage.initStyle(StageStyle.UNDECORATED);
        try {
            Process[] arr = new Process[4];
            arr[0] = new Process(0, 3, 5, 0);
            arr[1] = new Process(1, 2, 10, 0);
            arr[2] = new Process(2, 6, 6, 0);
            arr[3] = new Process(3, 7, 2, 0);

            Priority runn = new Priority(arr, 100);
            Roben ro = new Roben(arr, 2, 100);
            //runn.run();
            ro.run();
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < runn.processResultList[i].workingIntervals.size(); j++) {
                    System.out.println(runn.processResultList[i].PIC + "==  work from  " + runn.processResultList[i].workingIntervals.get(j).getKey() + " to " + runn.processResultList[i].workingIntervals.get(j).getValue());
                }
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < ro.processResultList[i].workingIntervals.size(); j++) {
                    System.out.println(ro.processResultList[i].PIC + "==  work from  " + ro.processResultList[i].workingIntervals.get(j).getKey() + " to " + ro.processResultList[i].workingIntervals.get(j).getValue());
                }
            }

        } catch (Exception ex) {
            System.out.println("  " + ex.getMessage() + "res " + ex.getLocalizedMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
