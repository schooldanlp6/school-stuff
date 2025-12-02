public class Telefonbuch implements Datenelement {
    int uid;
    String name;
    int nummer;
    Telefonbuch(int uid, String name, int nummer){
        
    }
    public int getUID(){
        return uid;
    }
    
    public boolean SchluesselIstGleich(int id){
        return false;

    }
    public boolean SchluesselGroeßerAls(int id){
        return false;
    }
    public String InformationenAusgeben(){
        return "404 Not Found";
    }
}
