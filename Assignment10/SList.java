package Assignment10;

public class SList<T> {
    SListNode<T> head;
    SList(){
        head=null;
    }
    SList(T data){
        head = new SListNode<T>(data);
    }
    public SListIterator<T> getIterator(){
        return new SListIterator<T>(head);
    }

}
