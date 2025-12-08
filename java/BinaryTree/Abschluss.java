public class Abschluss extends TreeElement{
    
    TreeElement Einfuegen(Datenelement d){
        return (new Knoten(d));
    }

    TreeElement Suchen(Datenelement d) {
        return null;
    }

    void PrintTree(int depth){
        int i = 0;
        System.out.print("|");
        while (i < depth) {
            System.out.print("-");
            i++;
        }
        System.out.println("Platzhalter");
    }
}
