public class MockData {
    public static void main(String[] args) {
        Warteschlange w1 = new Warteschlange();
        Datenelement d1 = new Patient("name");
        w1.HintenEinfügen(d1);
        Datenelement d2 = new Patient("name");
        w1.HintenEinfügen(d2);
        System.out.println("Länge: " + w1.WartschlangenLaengeGeben());
        System.out.println(w1.EndeEntfernen());
        System.out.println("Länge: " + w1.WartschlangenLaengeGeben());
        System.out.println(w1.Entfernen());
        w1.HintenEinfügen(d1);
    }    
}
//SUCHE