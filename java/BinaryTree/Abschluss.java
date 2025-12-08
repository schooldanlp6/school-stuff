public class Abschluss extends TreeElement{
    
    TreeElement Einfuegen(Datenelement d){
        return (new Knoten(d));
    }

    TreeElement Suchen(Datenelement d) {
        return null;
    }

    int HoechsteHoeheBerechnen(int hoehe){
        return hoehe - 1;
    }

    void PrintTree(int depth){
        int i = 0;
        System.out.print("|");
        while (i < depth + 1) {
            System.out.print("-");
            i++;
        }
        System.out.println("Platzhalter");
    }
}
