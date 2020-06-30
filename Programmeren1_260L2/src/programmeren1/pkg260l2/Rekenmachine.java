package programmeren1.pkg260l2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class Rekenmachine {
    public Button nul, een, twee, drie, vier, vijf, zes, zeven, acht, negen, 
                  C, plus, min, keer, deel, uitkomst;
    public TextField display;
    public Label label, label2;

    public int invoer = 0;
    public int invoer2 = 0;
    public String inStr = "0";    
    public char laatsteOp = ' ';
    
    public Rekenmachine(BorderPane b) {
        Berekening br = new Berekening();
        
        // Opzetten van het display
        display = new TextField();
        display.setEditable(false);
        display.setMaxWidth(215);
        display.setAlignment(Pos.CENTER_RIGHT);
        
        /* Toevoegen van de knoppen:
            7  8  9  /
            4  5  6  x
            3  2  1  +
            C  0  =  - 
        */
        zeven = new Button("7");
        zeven.setPrefSize(50, 50);
        zeven.setOnAction(event-> {
            inStr = display.getText();
            display.setText(inStr + "7");
        });
        acht = new Button("8");
        acht.setPrefSize(50, 50);
        acht.setOnAction(event-> {
            inStr = display.getText();
            display.setText(inStr + "8");
        });
        negen = new Button("9");
        negen.setPrefSize(50, 50);
        negen.setOnAction(event-> {
            inStr = display.getText();
            display.setText(inStr + "9");
        });
        deel = new Button("/");
        deel.setPrefSize(50, 50);
        deel.setOnAction(event -> {
            inStr = display.getText();
            invoer = Integer.parseInt(inStr);
            laatsteOp = '/';
            display.setText("");
        });
        
        vier = new Button("4");
        vier.setPrefSize(50, 50);
        vier.setOnAction(event-> {
            inStr = display.getText();
            display.setText(inStr + "4");
        });
        vijf = new Button("5");
        vijf.setPrefSize(50, 50);
        vijf.setOnAction(event-> {
            inStr = display.getText();
            display.setText(inStr + "5");
        });
        zes = new Button("6");
        zes.setPrefSize(50, 50);
        zes.setOnAction(event-> {
            inStr = display.getText();
            display.setText(inStr + "6");
        });       
        keer = new Button("x");
        keer.setPrefSize(50, 50);
        keer.setOnAction(event -> {
            inStr = display.getText();
            invoer = Integer.parseInt(inStr);
            laatsteOp = 'x';
            display.setText("");
        });
        
        een = new Button("1");
        een.setPrefSize(50, 50);
        een.setOnAction(event-> {
            inStr = display.getText();
            display.setText(inStr + "1");
        });
        twee = new Button("2");
        twee.setPrefSize(50, 50);
        twee.setOnAction(event-> {
            inStr = display.getText();
            display.setText(inStr + "2");
        });
        drie = new Button("3");
        drie.setPrefSize(50, 50);
        drie.setOnAction(event-> {
            inStr = display.getText();
            display.setText(inStr + "3");
        });
        plus = new Button("+");
        plus.setPrefSize(50, 50);
        plus.setOnAction(event -> {
            inStr = display.getText();
            invoer = Integer.parseInt(inStr);
            laatsteOp = '+';
            display.setText("");
        });

        nul = new Button("0");
        nul.setPrefSize(50, 50);
        nul.setOnAction(event-> {
            inStr = display.getText();
            display.setText(inStr + "0");
        });
        C = new Button("C");
        C.setPrefSize(50, 50);
        C.setOnAction(event -> {
            br.clear();
            inStr = "0";
            invoer = 0;
            invoer2 = 0;
            display.setText("");
        });
        
        /* Met de = knop worden de getallen naar de methoden gestuurd
           Het Switch statement leest de laatsteOp bepaald door welke knop 
           is ingedrukt (+, -, x, /) en activeert de bijbehorende methode */
        uitkomst = new Button("=");
        uitkomst.setPrefSize(50, 50);
        uitkomst.setOnAction(event -> {
            inStr = display.getText();
            invoer2 = Integer.parseInt(inStr);
            switch(laatsteOp) {
                case('+'):
                    br.telOp(invoer, invoer2);
                    display.setText(br.getResultaat() + "");
                    break;
                case('-'):
                    br.trekAf(invoer, invoer2);
                    display.setText(br.getResultaat() + "");
                    break;
                case('x'):
                    br.vermenigvuldig(invoer, invoer2);
                    display.setText(br.getResultaat() + "");
                    break;
                case('/'):
                    br.verdeel(invoer, invoer2);
                    display.setText(br.getResultaat() + "");
                    break;
                case('='):
                    invoer = 0;
                    invoer2 = 0;
                    inStr = "0";
                    laatsteOp = ' ';
                    break;
            }
        });  
        min = new Button("-");
        min.setPrefSize(50, 50);
        min.setOnAction(event -> {
            inStr = display.getText();
            invoer = Integer.parseInt(inStr);
            laatsteOp = '-';
            display.setText("");
        });
        
        // Opzetten van het logo en de text dat 
        // verschijnt na het klikken op het logo.
        label = new Label();
        label.setAlignment(Pos.CENTER);
        label2 = new Label();
        label2.setAlignment(Pos.CENTER);
        
        // De afbeelding staat in een aparte package (SourcePackages/image1)
        Image image1 = new Image("file:src/image1/CSClogo.png");
        ImageView cscLogo = new ImageView(image1);
        cscLogo.setFitWidth(215);
        cscLogo.setFitHeight(60);
        cscLogo.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> { 
            label.setText("Computer Sciences Corporation");
            label2.setText("www.CSC.com");
            event.consume();
        });
        
        /* BorderPane layout:
        TOP     - VBox met TextField
        CENTER  - GridPane met de knoppen
        BOTTOM  - VBox met Imageview en twee Labels
        */        
        b.setPadding(new Insets(10, 10, 10, 10));
        
        VBox displayBox = new VBox();
            displayBox.getChildren().add(display);
            displayBox.setAlignment(Pos.CENTER);
        b.setTop(displayBox); // TOP met VBox en TextField display
        
        GridPane knopPane = new GridPane();
            knopPane.setPadding(new Insets(10, 10, 10, 10));
            knopPane.setVgap(5);
            knopPane.setHgap(5);
        
            knopPane.add(zeven, 0, 0);
            knopPane.add(acht, 1, 0);
            knopPane.add(negen, 2, 0);
            knopPane.add(deel, 3, 0);
        
            knopPane.add(vier, 0, 1);
            knopPane.add(vijf, 1, 1);
            knopPane.add(zes, 2, 1);
            knopPane.add(keer, 3, 1);
        
            knopPane.add(een, 0, 2);
            knopPane.add(twee, 1, 2);
            knopPane.add(drie, 2, 2);
            knopPane.add(plus, 3, 2);

            knopPane.add(nul, 0, 3);
            knopPane.add(C, 1, 3);
            knopPane.add(uitkomst, 2, 3);
            knopPane.add(min, 3, 3);       
        b.setCenter(knopPane); // CENTER met de 16 knoppen
        
        VBox imageBox = new VBox();
            imageBox.getChildren().add(cscLogo);
            imageBox.getChildren().add(label);
            imageBox.getChildren().add(label2);
            imageBox.setAlignment(Pos.CENTER);
        b.setBottom(imageBox); // BOTTOM met Imageview en Image voor het logo
    }
}