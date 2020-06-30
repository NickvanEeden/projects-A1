package programmeren1.pkg260l2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class IZ260L2 extends Application {
    
    @Override
    public void start(Stage primaryStage) {  
        BorderPane b = new BorderPane(); // Creër het BorderPane
        
        Scene scene = new Scene(b);
        new Rekenmachine(b); // Verbind de klasse Rekenmachine met IZ260L2
        
        primaryStage.setTitle("Rekenmachine");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}