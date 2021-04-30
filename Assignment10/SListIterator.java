package Assignment10;

public class SListIterator <T> {
    public SListNode<T> head;
    public SListNode<T> current;
    int count;

    public SListIterator(SListNode<T> head){
        this.head=head;
    }

    public void insert(T data){
        count++;
        if(head==null){
            head = new SListNode<T>(data);
            current = head;
        }
        else{
            current.next = new SListNode<T>(data);
            current = current.next;
        }
        System.out.println("inserted: "+data);
    }

    public void remove(T data){
        if(head==null){
            System.out.println("List is empty");
        }
        else if(String.valueOf(head.data).equals(String.valueOf(data))){
            head = head.next;
            count--;
            System.out.println("removed: "+data);
        }
        else{
            SListNode<T> pre=head,nodeToDelete=null;
            while (pre.next!=null){
                nodeToDelete = pre.next;
                if(String.valueOf(nodeToDelete.data).equals(String.valueOf(data))){
                    pre.next=nodeToDelete.next;
                    count--;
                    System.out.println("removed: "+data);
                    return;
                }
                else{
                    pre=pre.next;
                }
            }
           System.out.println(data+" -> item not found");
        }
    }

    public void displayList(){
        if(head==null){
            System.out.println("List is empty");
        }
        else{
            SListNode<T> temp = head;
            System.out.print("[");
            while(temp!=null){
                System.out.print(" "+temp.data);
                if((temp = temp.next)!=null) System.out.print(",");
            }
            System.out.println(" ]");
        }
    }

    public void getSize(){
        System.out.println("size of list is : "+count);
    }
}
