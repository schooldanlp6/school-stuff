public class Stapel {
    Liste liste;
    
    Stapel(){
        liste = new Liste();
    }

    void VorneEinfuegen(Datenelement datenelement){
        liste.VorneEinfuegen(datenelement);
    }

    Datenelement Entfernen(){
        Datenelement datenelement = liste.Entfernen();
        return datenelement;
    }

    public static void main(String[] args) {
        
    }
}