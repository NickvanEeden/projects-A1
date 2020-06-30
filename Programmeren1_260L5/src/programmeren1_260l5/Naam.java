package programmeren1_260l5;


public class Naam {
    private String naam = "";
    private int sommen;
    
    /**
     * 
     * @param naam 
     */
    public void setNaam(String naam){
        this.naam = "";
        this.naam += naam;
    }
    
    /**
     * 
     * @return 
     */
    public String getNaam() {
        return naam;
    }

    /**
     * 
     * @param aantalSommen 
     */
    public void setAantalSommen(int aantalSommen){
        this.sommen = 0;
        this.sommen = aantalSommen;
    }
    
    /**
     * 
     * @return 
     */
    public int getAantalSommen(){
        return sommen;
    }
}