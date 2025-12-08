public class BinTree{
    TreeElement root;
    static TreeElement abschluss;

    BinTree(){
        root = new Abschluss();
        abschluss = root;
    }

    void Einfuegen(Datenelement d){
        root = root.Einfuegen(d);
    }
    //oder Datenelement
    String Suchen(Datenelement d_vgl){
        if(root.Suchen(d_vgl) == null){
            return "404 Not Found."; //try to catch it with String not found
        }else{
            return d_vgl.InformationenAusgeben();
        }
    }

    void PrintTree(){
        System.out.println(".");
        root.PrintTree(0);
    }

    static public TreeElement AbschlussGeben(){
        return abschluss;
    }
}