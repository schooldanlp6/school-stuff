public class WARTESCHLANGE
{
    KNOTEN anfKnoten;

    public WARTESCHLANGE(KNOTEN kanf, KNOTEN kend) 
    {
        anfKnoten = kanf;
    }

    public void einfuegen(KNOTEN k)
    {
        if(anfKnoten!=null){
            System.err.println(k.id);
        }else{
            
            System.err.println(k.id);
        }
    }

    public void entfernen(){
        if(anfKnoten==endKnoten){
            anfKnoten = endKnoten = null;
        }
        else{
            if(anfKnoten==null)
                {
                    anfKnoten=null;
                    endKnoten=null;
                    System.out.println("Empty...");
                }
                else{
                    anfKnoten=anfKnoten.nachfolger;
                }
            }
        }

    private void ausgabe()
    {
        KNOTEN knoten = anfKnoten;
        while(knoten.nachfolger!=null){
            System.out.println("Dieser Knoten hat Lied: " + anfKnoten.datenAusgabe() + " und ist knoten: " + Integer.toString(knoten.id));
            try{
                knoten = knoten.nachfolger;
            }
            catch(Exception e){System.out.println("End of cue");}
            if(knoten.nachfolger==null){
                try {
                    knoten.datenAusgabe();
                } catch (Exception e) {
                    System.out.println("You shouldnt get here");
                }
            }
        }
    }

    private void ausgabeknoten(){
        System.out.println(anfKnoten.id);
    }
     
    public static void main(String[] args)
    {
        WARTESCHLANGE w1 = new WARTESCHLANGE(null, null);
        DATEN l1 = new LIED("Chicken Banana", "Crazy Music Channel", 132, "9379498738i");
        DATEN l2 = new LIED("Chicken Banana", "Crazy Music Channel", 132, "9379298738i");
        DATEN l3 = new LIED("Wackelkontakt", "oimara", 168,"39859348ur34");
        
        KNOTEN k1 = new KNOTEN(l1, 0);
        w1.einfuegen(k1);
        w1.ausgabeknoten();
        KNOTEN k2 = new KNOTEN(l2, 1);
        w1.einfuegen(k2);
        w1.ausgabeknoten();
        KNOTEN k3 = new KNOTEN(l3, 2);
        w1.einfuegen(k3);
        w1.ausgabeknoten();
        KNOTEN k5 = new KNOTEN(l3, 4);
        w1.einfuegen(k5);
        KNOTEN k4 = new KNOTEN(l2, 3);
        w1.einfuegen(k4);
        KNOTEN k6 = new KNOTEN(l1, 5);
        w1.einfuegen(k6);
        KNOTEN k7 = new KNOTEN(l3, 6);
        w1.einfuegen(k7);
        
        w1.ausgabe();
        w1.ausgabeknoten();
        System.out.println("Foo");
        w1.entfernen();
        w1.einfuegen(k1);
        w1.ausgabeknoten();
        w1.ausgabe();
    }
}