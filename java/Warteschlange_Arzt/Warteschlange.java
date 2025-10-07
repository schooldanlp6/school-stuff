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
            if (anfang != null)
            {
                anfang = anfang.NachfolgerGeben();
                return anfang.DatenelementGeben();
            }
            else
            {
                try {
                    anfang=anfang.NachfolgerGeben();                    
                } catch (Exception e) {
                    return null;
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

    Knoten PatientAufrufen(String s){
        if (anfang!=null){
            if(anfang.SearchEval(s)){
                return anfang;
            }else{
                Boolean eval = false;
                Knoten some;
                try {
                    some = anfang.NachfolgerGeben();
                    eval = some.SearchEval(s);
                } catch (Exception e) {
                    eval = true;
                    return null;
                }
                while(eval==false){
                    try {
                        some = some.NachfolgerGeben();
                        eval = some.SearchEval(s);
                    }catch (Exception e) {
                        System.out.println("No Name Named " + s );
                        return null;
                    }
                    if (eval==true){
                        return some;
                    }
                }
            }
        }else{
            System.out.println("empty");
            return null;
        }
    }

/* public static void main(String[] args){
        Warteschlange w1 = new Warteschlange();
        Datenelement d1 = new Patient("Name");
        w1.HintenEinfügen(d1);

    }
*/
}
