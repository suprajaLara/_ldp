package Assignment10;

public class Assignment10 {
    public static void main(String[] args) {
        SList<Integer> sList = new SList<Integer>();
        SListIterator iterator = sList.getIterator();
    
        iterator.insert(100);
        iterator.insert(200);
        iterator.insert(300);
        iterator.insert(400);
        
        iterator.getSize();
        iterator.displayList();

        iterator.remove(300);
        iterator.remove(100);
        iterator.remove(500);

        iterator.getSize();
        iterator.displayList();
    }
    
}
