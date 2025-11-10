public class Gleis {
    Stapel gleis;
    
    Gleis(){
        gleis = new Stapel();
    }

    void Einfuegen(Datenelement dneu){
        gleis.VorneEinfuegen(dneu);
    }

    Datenelement Entfernen(){
        return gleis.Entfernen();
    }
}