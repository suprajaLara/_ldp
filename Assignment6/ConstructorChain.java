package Assignment6;

//PART-2
public class ConstructorChain {
    String name;
    int rating;
    public ConstructorChain(String name){
        this(name,5);
    }
    public ConstructorChain(String name, int rating){
        this.name = name;
        this.rating = rating;
    }
}
