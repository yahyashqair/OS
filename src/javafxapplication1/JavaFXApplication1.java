/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 *
 * @author YahyaShqair
 */
public class JavaFXApplication1 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        System.out.println("javafxapplication1.JavaFXApplication1.start()");
       // stage.initStyle(StageStyle.UNDECORATED);
              
    
    
    
        try{
        Process arr[]=new Process[4];
        arr[0]=new Process(0,3,5,0);
        arr[1]=new Process(1,2,10,0);
        arr[2]=new Process(2,6,6,0);
        arr[3]=new Process(3,7,2,0);

        Priority runn=new Priority(arr,100);
        Roben ro=new Roben(arr,2,100);
        //runn.run();
        ro.run();
      for (int i = 0; i < arr.length; i++) {
           for (int j = 0; j < runn.arr[i].worklist.size(); j++) {
               System.out.println(runn.arr[i].PIC+"==  work from  "+runn.arr[i].worklist.get(j).getKey()+" to "+runn.arr[i].worklist.get(j).getValue());
           } 
        }
      
       for (int i = 0; i < arr.length; i++) {
           for (int j = 0; j < ro.arr[i].worklist.size(); j++) {
               System.out.println(ro.arr[i].PIC+"==  work from  "+ro.arr[i].worklist.get(j).getKey()+" to "+ro.arr[i].worklist.get(j).getValue());
           }
        }
      
      
        }
        catch(Exception ex){
                System.out.println("  "+ex.getMessage()+"res "+ex.getLocalizedMessage());
        }
        
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
         
        launch(args);
    }
    
}
