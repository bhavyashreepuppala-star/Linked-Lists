public class Doubly_linkedList<T>
{
    public Doubly_linkedList()
    {
        head=null;
        size=0;
    }
    private static class Node<T>
    {
        T data;
        Node<T> prev;
        Node<T> next;
        Node(T data)
        {
            this.data=data;
            this.prev=null;
            this.next=null;
        }
    }
    private Node<T> head;
    private int size;
    public void insertfirst(T data)
    {
        Node<T> n1 = new Node<>(data);
        if(head==null)
        {
            head=n1;
        }
        else
        {
            n1.next=head;
            head.prev=n1;
            head=n1;
        }
        size++;
    }
    public void insertmiddle(T data) 
    {
        Node<T> n1 = new Node<>(data);
        if (head == null) 
        {
            head = n1;
        } 
        else
        {
            Node<T> slow = head;
            Node<T> fast = head;
            while (fast.next != null && fast.next.next != null)
            {
                slow = slow.next;
                fast = fast.next.next;
            }
            n1.next = slow.next;
            n1.prev = slow;        
            if (slow.next != null)
            {
                slow.next.prev = n1;
            }
            slow.next = n1;
        }
        size++;
    }
    public void insertlast(T data)
    {
        Node<T> n1 = new Node<>(data);
        
        if(head==null)
        {
            head=n1;
        }
        else
        {
            Node<T> curr = head;
            while(curr.next!=null)
            {
                curr=curr.next;
            }
            curr.next = n1;
            n1.prev=curr;
        }
        size++;
    }
    public void deletefirst()
    {
        if (head == null) 
        {
            return;
        }
        head=head.next;
        if(head!=null)
        {
            head.prev=null;
        }
        size--;
    }
    public void deletemiddle()
    {
        if (head == null || head.next == null) 
        {
            return;
        }
        Node<T> slow=head;
        Node<T> fast=head;  
        Node<T> target;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        } 
        target=slow.next;
        if(target==null)
        {
            return;
        }
        slow.next=target.next;
        if (target.next != null)
        {
            target.next.prev = slow;
        }
        size--;
    }
    public void deletelast()
    {
        Node<T> curr = head;
        if(head==null)
        {
            return;
        }
        if(head.next==null)
        {
            head=null;
            size--;
            return;
        }
        while(curr.next.next!=null)
        {
            curr=curr.next;
        }
        curr.next=null;
        size--;
    }
    public void traverse()
    {
        Node<T> curr=head;
        while(curr!=null)
        {
            System.out.print(curr.data);
            if(curr.next!=null)
            {
                System.out.print("->");
            }
            curr=curr.next;
        }
        System.out.println();
    }
    public int length ()
    {
        return size;
    }
    public static void main(String[] args)
    {
        Doubly_linkedList<Integer> list=new Doubly_linkedList<>();
        list.insertfirst(20);
        list.insertfirst(10);
        list.insertmiddle(15);
        list.insertlast(40);
        System.out.println("The list:");
        list.traverse();
        System.out.println("The length of list: "+list.length());
        list.deletefirst();
        list.deletemiddle();
        list.deletelast();
        System.out.println("The list:");
        list.traverse();
        System.out.println("The length of list: "+list.length());
    }
}
