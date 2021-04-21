public class SingleTon {
    private static SingleTon object;
    public String username;
    private SingleTon(String username){
        this.username=username;
        System.out.println("Instance created by "+username);
    }
    public static SingleTon getInstance(String username){
        if(object == null){
            object = new SingleTon(username);
        }
        else{
            System.out.println("Object is already created");
        }
        return object;
    }
    public void displayMessage(){
        System.out.println("Displaying message from "+username);
    }
}
