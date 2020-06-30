package programmeren1_260l5;

import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author NPT
 */

public class OefeningenScherm {
    private Naam naam;
    private Oefeningen oef;
    private Button volgende;
    private Text welkom, som;
    private TextField antwoordVak;
    private TextArea status;    
    private char operator, shuffleOperator;
    private int counter, input, aantal, aantalGoed, aantalFout, aantalTeGaan, 
            getalA, getalB, antwoord, shuffleAntwoord;  
    
    public OefeningenScherm(Stage primaryStage, Naam naam, String keuzeShuffleWaarde, String groep) {
        this.naam = naam;
        
        /**
         * 
         * Opzetten GUI en objecten/variabelen
         */
        GridPane p = new GridPane();
        Scene scene = new Scene(p, 600, 350);
        primaryStage.setScene(scene);        
        
        aantal = naam.getAantalSommen();        
        aantalGoed = 0;
        aantalFout = 0;
        aantalTeGaan = aantal;
        counter = 1;        
    
        welkom = new Text ("Welkom " + naam.getNaam() + ", Vul het antwoord van de volgende som in:");
        
        // De eerste som word gegenereert 
        oef = new Oefeningen(); 
            oef.setOperator(aantal, counter);
            
            getalA = oef.getGetalA(groep);
            getalB = oef.getGetalB(groep);
            
            operator = oef.getOperator();
            shuffleOperator = oef.getShuffleOperator();
            
            antwoord = oef.getAntwoord(getalA, operator, getalB); 
            shuffleAntwoord = oef.getAntwoord(getalA, shuffleOperator, getalB);
        
        if(keuzeShuffleWaarde.equals("Ja")) {
            som = new Text("  " + getalA + "  " + shuffleOperator + "  " + getalB + "  = ");
            
        } else if(keuzeShuffleWaarde.equals("Nee")) {
            som = new Text("  " + getalA + "  " + operator + "  " + getalB + "  = ");
        }
        
        som.setTextAlignment(TextAlignment.CENTER);
                 
        antwoordVak = new TextField();
        antwoordVak.setAlignment(Pos.CENTER);
        
        status = new TextArea("Aantal sommen tot nu toe goed: " + aantalGoed +
                              "\nAantal sommen tot nu toe fout: " + aantalFout +
                              "\nNog " + aantalTeGaan + " sommen te maken");       
        status.setEditable(false);
        status.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        welkom.setTextAlignment(TextAlignment.CENTER);                
        
        volgende = new Button("Volgende som");
        volgende.setMaxWidth(Double.MAX_VALUE);
        
        p.setAlignment(Pos.CENTER);
        p.setVgap(10);
        p.setHgap(10);
        p.setPadding(new Insets(10,10,10,10));
        p.add(welkom, 0,1,2,1);
        p.add(som, 0,2);
        p.add(antwoordVak, 1,2);
        p.add(volgende, 0,3);
        p.add(status, 0,4,2,2);

                            

        /**
         * 
         * Event handling Button volgende
         */         
        // Willekeurige volgorde (shuffle)
        volgende.setOnAction(e -> { 
            input = Integer.parseInt(antwoordVak.getText());
            if(keuzeShuffleWaarde.equals("Ja")) {
                if(input == shuffleAntwoord) {
                    aantalGoed++;
                    aantalTeGaan--; 
                         
                    // Genereer nieuwe som en check of de som niet op 1 of lager uitkomt
                    do {
                        getalA = oef.getGetalA(groep);
                        shuffleOperator = oef.getShuffleOperator();
                        getalB = oef.getGetalB(groep);
                        shuffleAntwoord = oef.getAntwoord(getalA, shuffleOperator, getalB);
                    }                                       
                    while(shuffleAntwoord <= 1);
                    
                    // Check of er een deling plaatsvind en of deze op een geheel getal uitkomt
                    if(shuffleOperator == '/' && getalA % getalB != 0) {
                        do {
                            getalA = oef.getGetalA(groep);
                            getalB = oef.getGetalB(groep);
                            shuffleAntwoord = oef.getAntwoord(getalA, shuffleOperator, getalB);                           
                        }
                        while(getalA % getalB != 0);
                    }
                        
                    som.setText("  " + getalA + "  " + shuffleOperator + "  " + getalB + "  = ");                   
                
                // Bij een foutief antwoord
                } else if(input != shuffleAntwoord) {
                    aantalFout++;
                    aantalTeGaan--;                
                    
                    // Genereer nieuwe som en check of de som niet op 1 of lager uitkomt
                    do {
                        getalA = oef.getGetalA(groep);
                        shuffleOperator = oef.getShuffleOperator();
                        getalB = oef.getGetalB(groep);
                        shuffleAntwoord = oef.getAntwoord(getalA, shuffleOperator, getalB);
                    }
                    while(shuffleAntwoord <= 1);
                        
                    // Check of er een deling plaatsvind en of deze op een geheel getal uitkomt
                    if(shuffleOperator == '/' && getalA % getalB != 0) {
                        do {
                            getalA = oef.getGetalA(groep);
                            getalB = oef.getGetalB(groep);
                            shuffleAntwoord = oef.getAntwoord(getalA, shuffleOperator, getalB);                           
                        }
                        while(getalA % getalB != 0);
                    }
                    
                    som.setText("  " + getalA + "  " + shuffleOperator + "  " + getalB + "  = ");
                }

            // Bij een niet willekeurige volgorde
            } else if(keuzeShuffleWaarde.equals("Nee")) {
                if(input == antwoord) { 
                    aantalGoed++;
                    aantalTeGaan--; 
                    counter++;
                    
                    oef.setOperator(aantal, counter);
                    
                    // Genereer nieuwe som en check of de som niet op 1 of lager uitkomt
                    do {
                        getalA = oef.getGetalA(groep);                                        
                        operator = oef.getOperator();                    
                        getalB = oef.getGetalB(groep);
                        antwoord = oef.getAntwoord(getalA, operator, getalB);
                    }
                    while(antwoord <= 1);

                    // Check of er een deling plaatsvind en of deze op een geheel getal uitkomt
                    if(operator == '/' && getalA % getalB != 0) {
                        do {
                            getalA = oef.getGetalA(groep);
                            getalB = oef.getGetalB(groep);
                            antwoord = oef.getAntwoord(getalA, operator, getalB);                           
                        }
                        while(getalA % getalB != 0);
                    }
                    
                    som.setText("  " + getalA + "  " + operator + "  " + getalB + "  = ");                   
                
                    
                // Bij een foutief antwoord    
                } else if(input != antwoord) {
                    aantalFout++;
                    aantalTeGaan--;   
                    counter++; 
                    
                    oef.setOperator(aantal, counter);
                    
                    // Genereer nieuwe som en check of de som niet op 1 of lager uitkomt
                    do {
                        getalA = oef.getGetalA(groep);
                        operator = oef.getOperator();
                        getalB = oef.getGetalB(groep);
                        antwoord = oef.getAntwoord(getalA, operator, getalB);
                    }                    
                    while(antwoord <= 1);                           
                        
                    // Check of er een deling plaatsvind en of deze op een geheel getal uitkomt
                    if(operator == '/' && getalA % getalB != 0) {
                        do {
                            getalA = oef.getGetalA(groep);
                            getalB = oef.getGetalB(groep);
                            antwoord = oef.getAntwoord(getalA, operator, getalB);                           
                        }
                        while(getalA % getalB != 0);
                    }
                    
                    som.setText("  " + getalA + "  " + operator + "  " + getalB + "  = ");
                }
            }
 
            status.setText("Aantal sommen tot nu toe goed: " + aantalGoed +
                           "\nAantal sommen tot nu toe fout: " + aantalFout +
                           "\nNog " + aantalTeGaan + " sommen te maken");
                
            if(aantalTeGaan == 1) {
                volgende.setText("Naar resultaat");
            }               
            
            if(aantalTeGaan > 0) {
                antwoordVak.clear();       
            }
            
            if(aantalTeGaan == 0) {
                new ResultaatScherm(primaryStage, naam, aantalGoed, aantalFout);
            }
        });      
        
        
        
        /**
         * 
         * Event handling TextField antwoordVak
         */
        // Willekeurige volgorde (shuffle)
        antwoordVak.setOnAction(e -> { 
            input = Integer.parseInt(antwoordVak.getText());
            if(keuzeShuffleWaarde.equals("Ja")) {
                if(input == shuffleAntwoord) {
                    aantalGoed++;
                    aantalTeGaan--; 
                         
                    // Genereer nieuwe som en check of de som niet op 1 of lager uitkomt
                    do {
                        getalA = oef.getGetalA(groep);
                        shuffleOperator = oef.getShuffleOperator();
                        getalB = oef.getGetalB(groep);
                        shuffleAntwoord = oef.getAntwoord(getalA, shuffleOperator, getalB);
                    }                                       
                    while(shuffleAntwoord <= 1);
                    
                    // Check of er een deling plaatsvind en of deze op een geheel getal uitkomt
                    if(shuffleOperator == '/' && getalA % getalB != 0) {
                        do {
                            getalA = oef.getGetalA(groep);
                            getalB = oef.getGetalB(groep);
                            shuffleAntwoord = oef.getAntwoord(getalA, shuffleOperator, getalB);                           
                        }
                        while(getalA % getalB != 0);
                    }
                        
                    som.setText("  " + getalA + "  " + shuffleOperator + "  " + getalB + "  = ");                   
                
                // Bij een foutief antwoord
                } else if(input != shuffleAntwoord) {
                    aantalFout++;
                    aantalTeGaan--;                
                    
                    // Genereer nieuwe som en check of de som niet op 1 of lager uitkomt
                    do {
                        getalA = oef.getGetalA(groep);
                        shuffleOperator = oef.getShuffleOperator();
                        getalB = oef.getGetalB(groep);
                        shuffleAntwoord = oef.getAntwoord(getalA, shuffleOperator, getalB);
                    }
                    while(shuffleAntwoord <= 1);
                        
                    // Check of er een deling plaatsvind en of deze op een geheel getal uitkomt
                    if(shuffleOperator == '/' && getalA % getalB != 0) {
                        do {
                            getalA = oef.getGetalA(groep);
                            getalB = oef.getGetalB(groep);
                            shuffleAntwoord = oef.getAntwoord(getalA, shuffleOperator, getalB);                           
                        }
                        while(getalA % getalB != 0);
                    }
                    
                    som.setText("  " + getalA + "  " + shuffleOperator + "  " + getalB + "  = ");
                }

            // Bij een niet willekeurige volgorde
            } else if(keuzeShuffleWaarde.equals("Nee")) {
                if(input == antwoord) { 
                    aantalGoed++;
                    aantalTeGaan--; 
                    counter++;
                    
                    oef.setOperator(aantal, counter);
                    
                    // Genereer nieuwe som en check of de som niet op 1 of lager uitkomt
                    do {
                        getalA = oef.getGetalA(groep);                                        
                        operator = oef.getOperator();                    
                        getalB = oef.getGetalB(groep);
                        antwoord = oef.getAntwoord(getalA, operator, getalB);
                    }
                    while(antwoord <= 1);

                    // Check of er een deling plaatsvind en of deze op een geheel getal uitkomt
                    if(operator == '/' && getalA % getalB != 0) {
                        do {
                            getalA = oef.getGetalA(groep);
                            getalB = oef.getGetalB(groep);
                            antwoord = oef.getAntwoord(getalA, operator, getalB);                           
                        }
                        while(getalA % getalB != 0);
                    }
                    
                    som.setText("  " + getalA + "  " + operator + "  " + getalB + "  = ");                   
                
                    
                // Bij een foutief antwoord    
                } else if(input != antwoord) {
                    aantalFout++;
                    aantalTeGaan--;   
                    counter++; 
                    
                    oef.setOperator(aantal, counter);
                    
                    // Genereer nieuwe som en check of de som niet op 1 of lager uitkomt
                    do {
                        getalA = oef.getGetalA(groep);
                        operator = oef.getOperator();
                        getalB = oef.getGetalB(groep);
                        antwoord = oef.getAntwoord(getalA, operator, getalB);
                    }                    
                    while(antwoord <= 1);                           
                        
                    // Check of er een deling plaatsvind en of deze op een geheel getal uitkomt
                    if(operator == '/' && getalA % getalB != 0) {
                        do {
                            getalA = oef.getGetalA(groep);
                            getalB = oef.getGetalB(groep);
                            antwoord = oef.getAntwoord(getalA, operator, getalB);                           
                        }
                        while(getalA % getalB != 0);
                    }
                    
                    som.setText("  " + getalA + "  " + operator + "  " + getalB + "  = ");
                }
            }
 
            status.setText("Aantal sommen tot nu toe goed: " + aantalGoed +
                           "\nAantal sommen tot nu toe fout: " + aantalFout +
                           "\nNog " + aantalTeGaan + " sommen te maken");
                
            if(aantalTeGaan == 1) {
                volgende.setText("Naar resultaat");
            }               
            
            if(aantalTeGaan > 0) {
                antwoordVak.clear();       
            }
            
            if(aantalTeGaan == 0) {
                new ResultaatScherm(primaryStage, naam, aantalGoed, aantalFout);
            }
        });
    }     
}