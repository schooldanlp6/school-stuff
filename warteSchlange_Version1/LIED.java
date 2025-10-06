public class LIED implements DATEN
{
    String titel;
    String interpret;
    int laenge; //Länge in Sekunden
    String mp3data;
    int id;

    public LIED(String titel, String interpret, int laenge, String mp3data)
    {
        this.titel = titel;
        this.interpret = interpret;
        this.laenge = laenge;
        this.mp3data = mp3data;
    }
    @Override
    public String namenAusgabe(){
        return titel;
    }
    @Override
    public String datenAusgabe() {
    return titel;
    }
}