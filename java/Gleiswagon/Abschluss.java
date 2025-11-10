public class Abschluss extends Listenelement {
    Listenelement HintenEinfügen(Datenelement dneu){
    return new Knoten(dneu);
    }

    int LaengeGeben(){
        return 0;
    }

    Listenelement EndeEntfernen(){
        return this;
    }

    Listenelement Entfernen(){
        return this;
    }

    Listenelement VorEinfügen(Datenelement dneu, Datenelement d_vergleich) {
        return new Knoten(dneu);
    }
}