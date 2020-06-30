package programmeren1_260l5;

import java.util.Random;

/**
 *
 * @author NPT
 */
public class Oefeningen { 
    private char operator, shuffleOperator;
    private int counter, welkeOperator, aantal, getalA, getalB, antwoord;
    private Random random;


    public Oefeningen() {
        random = new Random();
    }
    
    /**
     * 
     * @return
     * @param groep
     */
    public int getGetalA(String groep) {
        switch(groep) {
            case "Groep 3":
                getalA = random.nextInt(10)+ 1;
                break;
            case "Groep 4":
                getalA = random.nextInt(20)+ 1;
                break;
            case "Groep 5":
                getalA = random.nextInt(100)+ 1;
                break;
            case "Groep 6":
                getalA = random.nextInt(300)+ 1;
                break;
            case "Groep 7":
                getalA = random.nextInt(500)+ 1;
                break;
            case "Groep 8":
                getalA = random.nextInt(999)+ 1;
                break;
            default:
                break;
        }        
        return getalA;
    }   
    
    /**
     * 
     * @return 
     * @param groep
     */
    public int getGetalB(String groep) {        
        switch(groep) {
            case "Groep 3":
                getalB = random.nextInt(10)+ 1;
                break;
            case "Groep 4":
                getalB = random.nextInt(15)+ 1;
                break;
            case "Groep 5":
                getalB = random.nextInt(20)+ 1;
                break;
            case "Groep 6":
                getalB = random.nextInt(50)+ 1;
                break;
            case "Groep 7":
                getalB = random.nextInt(100)+ 1;
                break;
            case "Groep 8":
                getalB = random.nextInt(999)+ 1;
                break;
            default:
                break;
        }        
        return getalB;
    }

    /**
     * 
     * @param aantal
     * @param counter 
     */
    public void setOperator(int aantal, int counter) {
        this.aantal = aantal;
        this.counter = counter;
    }
    
   /**
    * 
    * @return 
    * Bij geen shuffle van de sommen word de volgorde van de sommen: +, -, *, /
    */
    public char getOperator() {
        welkeOperator = aantal / 4;
        
        if(counter <= welkeOperator){
            operator = '+';
        }
        
        if(counter > welkeOperator && counter <= welkeOperator * 2) {
            operator = '-';
        }
        
        if(counter > welkeOperator * 2 && counter <= welkeOperator * 3) {
            operator = '*';
        }
        
        if(counter > welkeOperator * 3 && counter <= welkeOperator * 4) {
            operator = '/';
        }        
        return operator;
    }
    
    /**
     * 
     * @return 
     */
    public char getShuffleOperator() {
        switch(random.nextInt(3)) {
            case 0:
                shuffleOperator = '+';
                break;
            case 1:
                shuffleOperator = '-';
                break;
            case 2:
                shuffleOperator = '*';
                break;
            case 3:
                shuffleOperator = '/';
                break;
        }
        return shuffleOperator;
    }
    
    /**
     * 
     * @param A
     * @param O
     * @param B
     * @return 
     * Het antwoord van de som gegenereerde som word hier bepaalt
     */
    public int getAntwoord(int A, char O, int B) {
        switch(O) {
            case '+':               
                antwoord = A + B;
                break;
            case '-':
                antwoord = A - B;
                break;
            case '*':
                antwoord = A * B;
                break;
            case '/':
                antwoord = A / B;
                break;
        }  
        return antwoord;
    }
}