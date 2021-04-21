public class Driver {
    public static void main(String args[]){
        SingleTon saiRam = SingleTon.getInstance("sai ram");
        SingleTon supraja = SingleTon.getInstance("supraja");
        SingleTon zemoso = SingleTon.getInstance("zemoso");
        saiRam.displayMessage();
        supraja.displayMessage();
        zemoso.displayMessage();
    }
}
