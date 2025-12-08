public class Knoten extends TreeElement {
    Datenelement data;
    TreeElement lnf = BinTree.AbschlussGeben();
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

    void PrintTree(int depth){
        depth++;
        int i = 0;
        System.out.print("|");
        while (i < depth) {
            System.out.print("-");
            i++;
        }
        System.out.println(data.getUID());
        lnf.PrintTree(depth);
        lnr.PrintTree(depth);
    }
}