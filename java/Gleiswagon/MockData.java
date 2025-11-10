public class MockData {
    MockData(){}
        public static void main(String[] args) {

        Gleis gleis = new Gleis();
        Datenelement d1 = new Wagon("A1001");
        Datenelement d2 = new Wagon("B1001");
        Datenelement d3 = new Wagon("A0121");
        gleis.Einfuegen(d1);
        System.out.println(d1);
        gleis.Einfuegen(d2);
        System.out.println(d3);
        gleis.Einfuegen(d3);
        System.out.println(gleis.Entfernen());
        System.out.println(gleis.Entfernen());
        System.out.println(gleis.Entfernen());
        System.out.println(gleis.Entfernen());
        System.out.println(gleis.Entfernen());
        System.out.println(gleis.Entfernen());
    }
}
