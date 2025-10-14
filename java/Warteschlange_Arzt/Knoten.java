/**
 * Beschreibung der Klasse Knoten
 * 
 * @author Klaus Reinold, Thomas Güntner
 * @version 1.0
 */
class Knoten
{
    /** Verwaltung des nachfolgenden Knoten in der Warteschlange. */
    private Knoten nachfolger;
    
    /** Verwaltung der Daten */
    private Datenelement daten;

    /**
     * Konstruktor des Knoten
     * @param dNeu Datenelement
     */
    Knoten(Datenelement dneu)
    {
        daten = dneu;
        nachfolger  = null;
    }

    void SortiertEinfügen(){}

    Knoten VorEinfügen(Datenelement dneu, Datenelement d_vergleich)
    {
        if (daten==d_vergleich){
            Knoten k = new Knoten(dneu);
            k.NachfolgerSetzen(this);
            return k;
        }else{
            nachfolger = nachfolger.VorEinfügen(dneu, d_vergleich);
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
    void HintenEinfügen(Datenelement dneu)
    {
        if(nachfolger != null)    
        {
            nachfolger.HintenEinfügen(dneu);
        }
        else
        {
            Knoten kneu;
            kneu = new Knoten(dneu);
            nachfolger = kneu;
        }
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
    Knoten NachfolgerGeben()
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
