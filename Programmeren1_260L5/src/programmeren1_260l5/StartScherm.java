package programmeren1_260l5;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author NPT
 */
public class StartScherm {
    private Naam naam;
    private Text welkomTekst;
    private TextField invoerveld;
    private Button startKnop;    
    
    public StartScherm(Stage primaryStage) { 
        
        /**
         * 
         * Opzetten GUI
         */
        GridPane p = new GridPane();
        Scene scene = new Scene(p, 600, 350);
        
        primaryStage.setScene(scene);
        
        naam = new Naam();
        
        welkomTekst = new Text("Vull hieronder je naam in om de Reken Trainer te starten");
        
        startKnop = new Button("Start");
        
        invoerveld = new TextField();
            invoerveld.setMaxWidth(200);
            
        p.setAlignment(Pos.CENTER);
        p.setPadding(new Insets(10, 10, 10, 10));
        p.setVgap(10);
        p.setHgap(10);
        
        p.add(welkomTekst, 0,0);
        p.add(invoerveld, 0,1);
        p.add(startKnop, 0,2); 
          
        
        /**
         * 
         * Event handling Button startKnop
         */
        startKnop.setOnAction(e -> {
            String invoer = invoerveld.getText();
                
            if (invoer.equals("")){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Naam");
                alert.setHeaderText(null);
                alert.setContentText("Je bent je naam vergeten in te vullen.");
                alert.showAndWait();
                
            } else {
                naam.setNaam(invoer);
                        
                new KeuzeScherm(primaryStage, naam);
            }
        });        
        
        /**
         * 
         * Event handling TextField invoerveld
         */
        invoerveld.setOnAction(e -> {
            String invoer = invoerveld.getText();                
            if (invoer.equals("")){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Naam");
                alert.setHeaderText(null);
                alert.setContentText("Je bent je naam vergeten in te vullen.");
                alert.showAndWait();
                
            } else {
                naam.setNaam(invoer);
                        
                new KeuzeScherm(primaryStage, naam);
            }
        });  
    }
}