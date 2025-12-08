public class Knoten extends TreeElement {
    Datenelement data;
    // Linker Nachfolger
    TreeElement lnf = BinTree.AbschlussGeben();
    // Rechter Nachfolger
    TreeElement lnr = BinTree.AbschlussGeben();

    Knoten(Datenelement d){
        data = d;
    }

    TreeElement Einfuegen(Datenelement d){
        if (data.SchluesselIstGleich(d.getUID())){
            return this;
        }
        if (data.SchluesselGroeßerAls(d.getUID())){
            lnr = lnr.Einfuegen(d);
            return this;
        }else{
            lnf = lnf.Einfuegen(d);
            return this;
        }
    }

    TreeElement Suchen(Datenelement d) {
        return this;
        //if (this.d.getUID() == d)
    }

    int HoechsteHoeheBerechnen(int hoehe){
        if (lnf.HoechsteHoeheBerechnen(hoehe+1) > lnr.HoechsteHoeheBerechnen(hoehe+1)){
            return lnf.HoechsteHoeheBerechnen(hoehe+1);
        }else{
            return lnr.HoechsteHoeheBerechnen(hoehe+1);
        }
    }

    void PrintTree(int depth){
        depth++;
        int i = 0;
        if (depth - 1 > 0){
            System.out.print("|");
        }
        while (i < depth - 1) {
            System.out.print("-");
            i++;
        }
        System.out.println(data.getUID());
        lnf.PrintTree(depth);
        lnr.PrintTree(depth);
    }
}