public class Wagon implements Datenelement{

    String gueter;
    String wagennr;
    Wagon(String wagennr){
        this.wagennr = wagennr;
    }
    @Override
    public String InformationAusgeben() {
        return gueter;
    }
    @Override
    public void NameSetzen(String name) {
        wagennr = name;
    }
    @Override
    public String NameGeben() {
        return wagennr;
    }
}