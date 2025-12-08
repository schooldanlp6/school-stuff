public abstract class TreeElement {
    TreeElement(){}
    abstract TreeElement Einfuegen(Datenelement d);
    abstract TreeElement Suchen(Datenelement d);
    abstract int HoechsteHoeheBerechnen(int hoehe);
    abstract void PrintTree(int depth);
}
