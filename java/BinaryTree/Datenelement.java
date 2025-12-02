public interface Datenelement {
    public static final int uid = 0; //refered to as schluessel
    default int getUID(){
        return uid;
    }
    
    default boolean SchluesselIstGleich(int id){
        return false;

    }
    default boolean SchluesselGroeßerAls(int id){
        return false;
    }
    default String InformationenAusgeben(){
        return "404 Not Found";
    }
}
