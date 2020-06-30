package programmeren1.pkg260l2;


public class Berekening {
    public int resultaat = 0;   

    public Berekening() {
        resultaat = 0;
    }
    
    // ingevoerde getallen worden opgeteld
    public void telOp(int invoer, int invoer2) { 
        resultaat = invoer + invoer2;  
    }
    
    // Het tweede ingevoerde getal word van het eerste afgetrokken
    public void trekAf(int invoer, int invoer2) {
        resultaat = invoer - invoer2; 
    }
    
    // ingevoerde getallen worden vermenigvuldigd met elkaar
    public void vermenigvuldig(int invoer, int invoer2) {
        resultaat = invoer * invoer2; 
    }
    
    // Het eerste ingevoerde getal word gedeeld door het tweede getal
    public void verdeel(int invoer, int invoer2) {
        resultaat = invoer / invoer2; 
    }
    
    // Wanneer op de = knop gedrukt word stuurt deze methode 
    // het resultaat van een berekening terug
    public int getResultaat() {
        return resultaat; 
    }
    
    // int resultaat word op 0 gezet bij het indrukken van de C knop
    public void clear() {
        resultaat = 0; 
    }
}