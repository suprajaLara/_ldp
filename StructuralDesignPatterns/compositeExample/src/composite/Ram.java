package composite;

public class Ram implements ComputerComponent{
    private double price;
    private String brand;

    public Ram(double price, String brand){
        this.price=price;
        this.brand=brand;
    }
    @Override
    public void showDetails() {
        System.out.println(this.getClass().getName()+"  - Brand: "+brand+"\t"+"Price: "+price);
    }
}
