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
    private void treeeinfuegen(String seit, Datenelement d){

    }
    TreeElement Suchen(Datenelement d) {
        return this;
        //if (this.d.getUID() == d)
    }
}
