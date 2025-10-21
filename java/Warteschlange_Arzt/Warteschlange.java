/**
 * Beschreibung der Warteschlange
 * 
 * @author Klaus Reinold, Thomas Güntner, Daniel Alvir
 * @version 1.0
 */
import java.util.Arrays;

class Warteschlange
{
    /** erster Knoten der Warteschlange */
    private Listenelement anfang;

    /**
     * Konstruktor der Warteschlange
     */
    Warteschlange()
    {
        anfang = new Abschluss();
    }

    
    Datenelement NameToDatenelement(String s){
        if(anfang!=null){
            Datenelement d = anfang.NameToDatenelement(s);
            return d;
        }else{
            return null;
        }
    }

    void VorEinfügen(Datenelement dneu, Datenelement d_vergleich)
    {
        if (anfang != null){
            anfang = anfang.VorEinfügen(dneu, d_vergleich);
        }
        else{
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

    void SortiertEinfügen(Datenelement d){
        int length = this.WartschlangenLaengeGeben();
        Listenelement[] data = new Listenelement[length];
        while (length > 0){
            length++;
            Listenelement k = anfang.SortiertEinfügen(length, 0);
            data[k.GetIndex()-1] = k;
        }
    }

    /**
     * Fügt ein neues Datenelement am Ende der Warteschlange ein.
     * @param dNeu neues Datenelement
     */
    void HintenEinfügen(Datenelement dneu)
    {
        anfang = anfang.HintenEinfügen(dneu);
    }

    /**
     * Entfernt den ersten Patient aus der Warteschlange und gibt ihn zurück.
     * @return bisheriger erster Patient 
     */
    Datenelement Entfernen()
    {
        Datenelement d = anfang.DatenelementGeben();
        anfang = anfang.Entfernen();
        return d;
    }

    Listenelement EndeEntfernen(){
        return anfang.EndeEntfernen();
    }

    int WartschlangenLaengeGeben(){
        return anfang.LaengeGeben();
    }

    String[] WarteschlangeAusgabeName(){
        int laenge = WartschlangenLaengeGeben();
        if (laenge!=0){

            return anfang.WarteschlangeAusgabeName(laenge);
            
            k.DatenelementGeben().NameGeben();
        }
    }

    /**
     * Gibt Information über die Warteschlange aus.
     */
    void InformationAusgeben()
    {
            anfang.InformationAusgeben();
    }

    Listenelement AnfangGeben(){
        return anfang;
    }

    Listenelement KnotenGeben(){
        if (anfang.NachfolgerGeben()==null){
            return anfang;
        }
        else{
            Listenelement nachfolger = anfang.NachfolgerGeben();
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
