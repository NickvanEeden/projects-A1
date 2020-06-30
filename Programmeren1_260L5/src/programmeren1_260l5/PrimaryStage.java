package programmeren1_260l5;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author NPT
 */
public class PrimaryStage extends Application {
    
    @Override
    public void start(Stage primaryStage) {       
        StartScherm s = new StartScherm(primaryStage);   
    
        primaryStage.setTitle("Reken Trainer");
        
        primaryStage.setFullScreen(false);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch (args);
    }
}