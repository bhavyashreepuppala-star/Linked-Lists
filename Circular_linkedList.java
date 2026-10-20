public class Circular_linkedList<T>
{
    public Circular_linkedList()
    {
        head=null;
        size=0;
    }
    private static class Node<T>
    {
        T data;
        Node<T> next;
        Node(T data)
        {
            this.data = data;
            this.next = next;
        }
    }
    private Node<T> head;
    private int size;
    public void insertfirst(T data)
    {
        Node<T> n1= new Node<>(data);
        if(head==null)
        {
            head=n1;
            n1.next=head;
        }
        else
        {
            Node<T> curr=head;
            while(curr.next!=head)
            {
                curr=curr.next;
            }
            curr.next=n1;
            n1.next=head;
            head=n1;
        }
        size++;
    }
    public void insertlast(T data)
    {
        Node<T> n1 = new Node<>(data);
        if(head==null)
        {
            head=n1;
            n1.next=head;
        }
        else
        {
            Node<T> curr=head;
            while(curr.next!=head)
            {
                curr=curr.next;
            }
            curr.next=n1;
            n1.next=head;
        }
        size++;
    }
    public void insertbetween(T data)
    {
        Node<T> n1= new Node<>(data);
        if(head==null)
        {
            head=n1;
            n1.next=head;
        }
        else
        {
            Node<T> slow=head;
            Node<T> fast=head;
            while(fast.next!=head && fast.next.next!=head)
            {
                slow=slow.next;
                fast=fast.next.next;
            }
            n1.next=slow.next;
            slow.next=n1;
        }
        size++;
    }
    public void traverse()
    {
        if(head==null)
        {
            return;
        }
        else
        {
            Node<T> curr=head;
            while(curr.next!=head)
            {
                System.out.print(curr.data + " ");
                curr=curr.next;
            }
        }
    }
    public void deletefirst()
    {
        if(head==null)
        {
            return;
        }
        if(head.next == head)
        {
            head = null;
        }
        else
        {
            Node<T> curr=head;
            while(curr.next!=head)
            {
                curr=curr.next;
            }
            head=head.next;
            curr.next=head;
        }
        size--;
    }
    public void deletelast()
    {
        if(head==null)
        {
            return;
        }
        if(head.next==null)
        {
            head=null;
        }
        else
        {
            Node<T> curr = head;
            while(curr.next.next!=head)
            {
                curr.next=head;
            }
        }
        size--;
    }
    public void deletemiddle()
    {
        if(head==null)
        {
            return;
        }
        if(head.next==head)
        {
            head=null;
        }
        else
        {
            Node<T> slow=head;
            Node<T> fast=head;
            while(fast.next!=head && fast.next.next!=head)
            {
                slow=slow.next;
                fast=fast.next.next;
            }
            slow.next=slow.next.next;
        }  
        size--;
    }
    public int length()
    {
        return size;
    }
    public static void main(String[]args)
    {
        Circular_linkedList<Integer> list=new Circular_linkedList<>();
        list.insertfirst(10);
        list.insertbetween(20);
        list.insertlast(30);
        list.insertlast(40);
        System.out.println("After addition:");
        list.traverse();
        System.out.println();
        System.out.println(list.length());
        list.deletefirst();
        list.deletemiddle();
        list.deletelast();
        System.out.println("After deletion:");
        list.traverse();
        System.out.println();
        System.out.println(list.length());

    }
}
