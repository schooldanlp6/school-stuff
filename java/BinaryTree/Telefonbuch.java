public class Telefonbuch implements Datenelement {
    int uid;
    String name;
    int nummer;
    Telefonbuch(int uid, String name, int nummer){
        this.uid = uid;
        this.name = name;
        this.nummer = nummer;
    }
    public int getUID(){
        return uid;
    }
    
    public boolean SchluesselIstGleich(int id){
        if (id==uid){
            return true;
        }else{
            return false;
        }
    }
    public boolean SchluesselGroeßerAls(int id){
        if (id>uid){
            return true;
        }else{
            return false;
        }
    }
    public String InformationenAusgeben(){
        return "404 Not Found";
    }
}
