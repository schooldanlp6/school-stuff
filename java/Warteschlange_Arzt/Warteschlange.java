/**
 * Beschreibung der Warteschlange
 * 
 * @author Klaus Reinold, Thomas Güntner
 * @version 1.0
 */
class Warteschlange
{
    /** erster Knoten der Warteschlange */
    private Knoten anfang;

    /**
     * Konstruktor der Warteschlange
     */
    Warteschlange()
    {
        anfang = null; 
    }

    void VorEinfügen(Datenelement dneu, Datenelement d_vergleich)
    {
        if (anfang != null){
            if(anfang.DatenelementGeben()==d_vergleich){
                Knoten knoten = anfang.VorEinfügen(dneu, d_vergleich);
                Knoten k = anfang;
                anfang = knoten;
                anfang.NachfolgerSetzen(k);
            }
            else{
                anfang.VorEinfügen(dneu, d_vergleich);
            }
        }else{
            anfang = new Knoten(dneu);
        }
    }

    void NachEinfügen(Datenelement dneu, Datenelement d_vergleich)
    {
        if (anfang != null) {
            anfang.NachEinfügen(dneu, d_vergleich);
        }else{
            anfang = new Knoten(dneu);
        }
    }

    /**
     * Fügt ein neues Datenelement am Ende der Warteschlange ein.
     * @param dNeu neues Datenelement
     */
    void HintenEinfügen(Datenelement dneu)
    {
        if (anfang != null)
        {
            anfang.HintenEinfügen(dneu);
        }
        else
        {
            anfang = new Knoten(dneu);
        }
    }

    /**
     * Entfernt den ersten Patient aus der Warteschlange und gibt ihn zurück.
     * @return bisheriger erster Patient 
     */
    Datenelement Entfernen()
    {
        if (anfang != null)
        {
            if (anfang.NachfolgerGeben() != null)
            {
                anfang = anfang.NachfolgerGeben();
                return anfang.DatenelementGeben();
            }
            else
            {
                try {
                    Knoten a = anfang;
                    anfang=anfang.NachfolgerGeben();
                    return a.DatenelementGeben();                    
                } catch (Exception e) {
                    return anfang.DatenelementGeben();
                }
            }
        }
        return anfang.DatenelementGeben();
    }

    int WartschlangenLaengeGeben(){
        if (anfang!=null){
            return anfang.LaengeGeben();
        }
        return 0;
    }

    /**
     * Gibt Information über die Warteschlange aus.
     */
    void InformationAusgeben()
    {
        if (anfang != null)
        {
            anfang.InformationAusgeben();
        }
    }

    Knoten KnotenGeben(){
        if (anfang.NachfolgerGeben()==null){
            return anfang;
        }
        else{
            Knoten nachfolger = anfang.NachfolgerGeben();
            return nachfolger;
            KnotenGeben();
        }
    }

    Boolean PatientAufrufen(String s){
        if (anfang!=null){
            Boolean res;
            res = anfang.SearchEval(s);
            return res;
        }
        return null;
    }

/* public static void main(String[] args){
        Warteschlange w1 = new Warteschlange();
        Datenelement d1 = new Patient("Name");
        w1.HintenEinfügen(d1);

    }
*/
}
