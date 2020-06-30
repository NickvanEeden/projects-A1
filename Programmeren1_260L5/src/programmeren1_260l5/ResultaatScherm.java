package programmeren1_260l5;

import java.text.DecimalFormat;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author NPT
 */
public class ResultaatScherm {
    private Naam naam;
    private Button nogEenKeer, stop;
    private Text tekstEinde;    
    private TextArea tekstScore;
    private int aantalGoed, aantalFout;
        
    public ResultaatScherm(Stage primaryStage, Naam naam, int aantalGoed, int aantalFout){
        this.naam = naam;
        this.aantalGoed = aantalGoed;
        this.aantalFout = aantalFout;
        
        /**
         * 
         * Opzetten GUI
         */
        GridPane p = new GridPane();
        Scene scene = new Scene(p, 600, 350);
            
        primaryStage.setScene(scene);
        DecimalFormat DFormat = new DecimalFormat("#.00"); 
               
        nogEenKeer = new Button ("Nog een keer");
        
        stop = new Button ("Stoppen");
        
        tekstScore = new TextArea ("Aantal sommen goed: " + aantalGoed + 
                                  "\nAantal sommen fout: " + aantalFout + 
                                  "\nscore " + DFormat.format(((naam.getAantalSommen() - aantalFout) / (double) 
                                  naam.getAantalSommen() * 100)) + "%");
        tekstScore.setEditable(false);
        tekstScore.setPrefHeight(60);
        
        tekstEinde = new Text ("Je hebt de  opdracht afgerond " + naam.getNaam() + 
                               ", hieronder zie je wat je resultaat is");        
        tekstEinde.setTextAlignment(TextAlignment.CENTER);
        
        p.setVgap(10);
        p.setHgap(10);
        p.setPadding(new Insets(10,10,10,10));
        p.add(tekstEinde, 0,1);
        p.add(tekstScore, 0,2 ,2,1);
        p.add(nogEenKeer, 0,3);
        p.add(stop, 1,3);
        
       
        /**
         * 
         * Event handling Buttons nogEenKeer en stop
         */
        nogEenKeer.setOnAction(e -> {        
            new KeuzeScherm(primaryStage, naam);
        });
        
        stop.setOnAction(e -> {
            Platform.exit();
        });         
    } 
}