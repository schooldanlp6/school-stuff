public class KNOTEN {
    KNOTEN nachfolger;
    DATEN daten;
    int id;

    
    public KNOTEN(DATEN daten, int id)
    {
        this.nachfolger = null;
        this.daten = daten;
        this.id = id;
    }

    public void nachfolgerSetzten(KNOTEN nachfolger){
        this.nachfolger = nachfolger;
    }

    public KNOTEN nachfolgerGeben(){
        return nachfolger;
    }
    public String datenAusgabe(){
        return daten.datenAusgabe();
    }
}
