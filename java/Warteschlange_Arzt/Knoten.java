/**
 * Beschreibung der Klasse Knoten
 * 
 * @author Klaus Reinold, Thomas Güntner
 * @version 1.0
 */
class Knoten extends Listenelement
{
    /** Verwaltung des nachfolgenden Knoten in der Warteschlange. */
    private Listenelement nachfolger;
    
    /** Verwaltung der Daten */
    private Datenelement daten;

    private int index;

    /**
     * Konstruktor des Knoten
     * @param dNeu Datenelement
     */
    Knoten(Datenelement dneu)
    {
        daten = dneu;
        nachfolger  = new Abschluss();
    }

    Listenelement SortiertEinfügen(int length, int this_length ){
        index = this_length + 1;
        if(nachfolger!=null){
            nachfolger.SortiertEinfügen(length, this_length);
        }
        return this;
    }

    Datenelement NameToDatenelement(String s){
        String name = daten.NameGeben();
        if (name.equals(s)){
            return daten;
        }else{
            try{
                return nachfolger.NameToDatenelement(s);
            }
            catch (Exception e) {
                System.out.println("Reached End of Cue");
                return null;
            }
        }
    }

    Listenelement VorEinfügen(Datenelement dneu, Datenelement d_vergleich)
    {
        if (daten==d_vergleich){
            Listenelement k = new Knoten(dneu);
            k.NachfolgerSetzen(this);
            return k;
        }else if(nachfolger!=null){
            nachfolger = nachfolger.VorEinfügen(dneu, d_vergleich);
            return this;
        }else{
            nachfolger = new Knoten(dneu);
            return this;
        }
    }

    void NachEinfügen (Datenelement dneu, Datenelement d_vergleich){
        if (dneu==d_vergleich) {
            Knoten knoten;
            knoten = new Knoten(dneu);
            knoten.nachfolger=this.nachfolger;
            this.nachfolger = knoten;
        }else{
            this.nachfolger.NachEinfügen(dneu, d_vergleich);
        }
    }

    /**
    * Fügt ein Datenelement am Ende der Liste ein
    * @param dneu neues Datenelement
    */
    Listenelement HintenEinfügen(Datenelement dneu)
    {
        nachfolger = nachfolger.HintenEinfügen(dneu);
        return this;
    }

    /**
     * Nachfolger des Knoten setzen
     * @param nf neuer Nachfolger
     */
    void NachfolgerSetzen(Knoten nf)
    {
        nachfolger = nf;
    }

    /**
     * Gibt den Nachfolger des Knoten aus.
     * @return Nachfolger
     */
    Listenelement NachfolgerGeben()
    {
        return nachfolger;
    }
    
    /**
     * Gibt das Datenelement zurück
     * @return Datenelement
     */
    Datenelement DatenelementGeben()
    {
        return daten;
    }

    int GetIndex(){
        return index;
    }
    
    /**
     * Gibt Information über das Datenelement aus.
     */
    void InformationAusgeben()
    {
        daten.InformationAusgeben();
    }

    int LaengeGeben(){
        if (nachfolger != null){
            return 1 + nachfolger.LaengeGeben();
        }else{
            return 1;
        }
    }

    Boolean SearchEval(String s){
        if(daten.NameGeben().equals(s)){
            return true;
        }else{
            SearchEval(s);
        }
        return false;
    }
}
