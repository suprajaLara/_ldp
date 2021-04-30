package Assignment10;

public class SListNode <T>{
    T data;
    SListNode<T> next;
    public SListNode(){}
    public SListNode(T data){
        this.data = data;
        next = null;
    }
}
