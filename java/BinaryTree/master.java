public class master {
    static BinTree t = new BinTree();
    public static void main(String[] args) {
        int x = 10;
        int i = x - x;
        //int[] di = new int[x];
        //String[] ds = new String[x];
        //int[] dn = new int[x];
        Datenelement[] d = new Datenelement[x];
        
        int[] di = {1,3,4,7,5,2,302,756,19,10};
        String[] ds = {"DanLP6","User2","User3","User4","User5","User6","User7","User8","User9","User10"};
        int[] dn = {1,2,3,4,5,6,7,8,9,0};

        while (i<=10){
            d[i] = new Telefonbuch(di[i], ds[i], dn[i]);
            Datenelement din = d[i];
            Insert(din);
            i = i++;
        }

    }
    master(){}
    void PrintTree(){
        t.PrintTree();
    }
    static void Insert(Datenelement d){
        t.Einfuegen(d);
    }
}
