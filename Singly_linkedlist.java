public class Singly_linkedlist<T>
{
    public Singly_linkedlist()
    {
        head=null;
        size=0;
    }
    private static class Node <T>
    {
        T data;
        Node<T> next;
        Node (T data)
        {
            this.data=data;
            this.next=null;
        }
    }
    private Node <T> head;
    private int size;
    public void insertfirst(T data)
    {
        Node <T> n1 = new Node<>(data);
        if(head==null)
        {
            head=n1;
        }
        else
        {
            n1.next=head;
            head=n1;
        }
        size++;
    }  
    public void insertmiddle(T data)
    {
        Node<T> n1 = new Node<>(data);
        Node<T> slow = head;
        Node<T> fast = head;
        if(head==null)
        {
            head=n1;
        }
        else
        {
            while(fast.next!=null && fast.next.next!=null)
            {
                slow=slow.next;
                fast=fast.next.next;
            }
        n1.next=slow.next;
        slow.next=n1;
        }
        size++;
    }
    public void insertlast(T data)
    {
        Node<T> n1 = new Node<>(data);
        Node<T> curr= head;
        if(head==null)
        {
            head=n1;
        }
        else
        {
            while(curr.next!=null)
            {
                curr=curr.next;
            }
            curr.next=n1;
        }
            size++;
    }
    public void deletefirst()
    {
        if(head==null)
        {
            System.out.println("Linkedlist is empty");
            return;
        }
        head=head.next;
        size--;
    }
    public void deletemiddle()
    {
        Node<T> slow=head;
        Node<T> fast=head;
        Node<T> prev=null;
        if(head==null)
        {
            System.out.println("Linkedlist is empty");
            return;
        }
        else
        {
            while(fast.next!=null && fast.next.next!=null)
                {
                    prev=slow;
                    slow=slow.next;
                    fast=fast.next.next;
                }
                if(prev==null)
                {
                    System.out.println("Nothing to delete");
                    return;
                }
                else
                {
                    prev.next= slow.next;
                }
        }
            size--;
    }
    public void deletelast()
    {
        Node<T> curr=head;
        if (head == null) 
        {
            System.out.println("Linkedlist is empty");
            return;
        }
        else if (head.next == null) 
        {
            head = null;
            size--;
            return;
        }
        else
        {
            while(curr.next.next!=null)
            {
                curr=curr.next;
            }
            curr.next=null;
        }
        size--;
    }
    public void traverse()
    {
        Node<T> curr=head;
        while(curr.next!=null)
        {
            System.out.print(curr.data+"->");
            curr=curr.next;
        }
        System.out.print(curr.data);
        System.out.println();
    }
    public int length()
    {
        return size;
    }
    public static void main(String[] args)
    {
        Singular_linkedlist<Integer> list = new Singular_linkedlist<>();
        list.insertfirst(20);
        list.insertfirst(10);
        list.insertlast(40);
        list.insertmiddle(30);
        System.out.println("Linked List:");
        list.traverse();
        System.out.println("Length: " + list.length());
        list.deletefirst();
        list.deletemiddle();
        list.deletelast();
        System.out.println("After deletion:");
        list.traverse();
        System.out.println("Length: " + list.length());
    }
}
