package programmeren1_260l5;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author NPT
 */
public class KeuzeScherm {
    private Naam naam;
    private Oefeningen oefGroep;
    private Text tekstGroep, tekstSommen, tekstShuffle;
    private TextField invoerveld;
    private Button startKnop;
    private RadioButton g3, g4, g5, g6, g7, g8, ja, nee;
    private ToggleGroup radioGroup1;
    private ToggleGroup radioGroup2;
    
    public KeuzeScherm(Stage primaryStage, Naam naam) {
        this.naam = naam;
        
        /**
         * 
         * Opzetten GUI
         */
        GridPane p = new GridPane();
        Scene scene = new Scene(p, 600, 350);
        
        primaryStage.setScene(scene);
        
        tekstGroep = new Text("Kies hier je groep");
        tekstSommen = new Text("Hoeveel sommen wil je maken? Kies minimaal 5 en maximaal 30");
        tekstShuffle = new Text("Wil je de sommen door elkaar heen?");
        
        invoerveld = new TextField();
        
        startKnop = new Button("Start Reken Trainer");
        
        radioGroup1 = new ToggleGroup();
        radioGroup2 = new ToggleGroup();
        
        g3 = new RadioButton("Groep 3");
        g3.setToggleGroup(radioGroup1);
        g4 = new RadioButton("Groep 4");
        g4.setToggleGroup(radioGroup1);
        g5 = new RadioButton("Groep 5");
        g5.setToggleGroup(radioGroup1);
        g6 = new RadioButton("Groep 6");
        g6.setToggleGroup(radioGroup1);
        g7 = new RadioButton("Groep 7");
        g7.setToggleGroup(radioGroup1);
        g8 = new RadioButton("Groep 8");
        g8.setToggleGroup(radioGroup1);
        
        ja = new RadioButton("Ja");
        ja.setToggleGroup(radioGroup2);
        nee = new RadioButton("Nee");
        nee.setToggleGroup(radioGroup2);  
        
        p.setAlignment(Pos.CENTER);
        p.setPadding(new Insets(10, 10, 10, 10));
        p.setVgap(10);
        p.setHgap(10);
        p.add(tekstGroep, 0,0);
        p.add(tekstSommen, 1,0);
        p.add(tekstShuffle, 1,1);
        p.add(invoerveld, 2,0);       
        p.add(ja, 1,2);
        p.add(nee, 1,3);
        p.add(startKnop, 1,4);       
        p.add(g3, 0,1);
        p.add(g4, 0,2);
        p.add(g5, 0,3);
        p.add(g6, 0,4);
        p.add(g7, 0,5);
        p.add(g8, 0,6);
        
        
        /**
         * 
         * Event handling Button startKnop
         */ 
        startKnop.setOnAction(e -> {
            RadioButton keuzeGroep = (RadioButton) radioGroup1.getSelectedToggle();
            RadioButton keuzeShuffle = (RadioButton) radioGroup2.getSelectedToggle();

            String groep = keuzeGroep.getText();            
            
            String keuzeShuffleWaarde = keuzeShuffle.getText();               
            
            int sommen = Integer.parseInt(invoerveld.getText());
            naam.setAantalSommen(sommen);
                                
            /**
             * 
             * Bij het niet kiezen van een groep komt een foutmelding
             */    
            if (keuzeGroep == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("test");
                alert.setHeaderText(null);
                alert.setContentText("Kies een groep");
                alert.showAndWait();  
                return;
                }
                
            /**
             * 
             * Bij het niet invullen van het TextField komt een foutmelding
             */
            if (invoerveld.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Aantal sommen");
                alert.setHeaderText(null);
                alert.setContentText("Kies hoeveel sommen je wilt doen");
                alert.showAndWait(); 
                return;
                }
                
            /**
             * 
             * Wanneer een getal kleiner dan 5 of groter dan 30 word ingevuld komt een foutmelding
             */
            if (Integer.parseInt(invoerveld.getText()) < 5 || Integer.parseInt(invoerveld.getText()) > 30) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Aantal sommen");
                alert.setHeaderText(null);
                alert.setContentText("Kies een aantal tussen 5 en 30");
                alert.showAndWait();  
                return;
                }
                
            /**
             * 
             * Wanneer geen shuffle ja/nee word aangeklikt komt een fout melding
             */
            if (keuzeShuffle == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Aantal sommen");
                alert.setHeaderText(null);
                alert.setContentText("Kies of je de sommen door elkaar heen wilt of niet");
                alert.showAndWait();  
                return;
                }
                                
            if (keuzeShuffleWaarde.equals("Ja")) {
                new OefeningenScherm(primaryStage, naam, keuzeShuffleWaarde, groep);
                                        
            } else if(keuzeShuffleWaarde.equals("Nee")) {
                new OefeningenScherm(primaryStage, naam, keuzeShuffleWaarde, groep);    
            }
        });      
    }
}