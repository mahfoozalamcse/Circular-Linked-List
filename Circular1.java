public class Circular1 {
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
    // insert at begining of the circular linked  time O(n)
    public static Node insert1(Node head, int x){
        Node curr = new Node(x);
        if (head == null) {
            curr.next = curr;
        }else{
         Node temp = head;
         while (temp.next != head) 
              temp = temp.next;
        temp.next = curr;
        curr.next = head;

        }
        return curr;
    }

    // method 2 efficient insert at O(1)
    public static Node insert2(Node head, int x){
        Node temp = new Node(x);
        if (head == null) {
            temp.next = temp;
            return temp;
            
        }else{
            
            temp.next = head.next;
            head.next = temp;
            int t = head.data;
            head.data = temp.data;
            temp.data = t;
        
           return head;
        }
    }

    // inseert at the end of circular Linked list O(n)
    public static Node insertEnd1(Node head, int x){
        Node temp = new Node(x);
        if (head == null) {
            
            temp.next = temp;
            return temp;
        }else{

        Node curr = head;
        while (curr.next != head) 
              curr = curr.next;
        curr.next = temp;
        temp.next = head;
        
        
        return head;
        }
    }

    // insert at the end O(1)
    public static Node insertEnd2(Node head, int x){
        Node temp = new Node(x);
        if (head == null) {
            temp.next = temp;
            return temp;
        }else{
            temp.next = head.next;
            head.next =  temp;
            int t = temp.data;
            temp.data = head.data;
            head.data = t;
        
        return temp;
        }
    }

    // traversal method 1 
    public static void printCirList(Node head){
        if (head == null) {
            return;
        }
        System.out.print(head.data+"<->");
        
        for(Node temp = head.next; temp != head; temp = temp.next){
            System.out.print(temp.data+"<->");
            
        }
    }

    // method 2 traverse using do while
    public static void traversel(Node head){
        if(head == null) return;
        Node p = head;
        do{
            System.out.print(p.data+"<->");
            p = p.next;
        }while(p != head);
    }
    public static void main(String[] args) {
       Node head = new Node(1);
       head.next = new Node(2);
       head.next.next = new Node(3);
       head.next.next.next = new Node(4);
       head.next.next.next.next = head;
    //    printCirList(head);
    //    System.out.println();
    //    traversel(head);

    // head = insert2(head, 0);
    // printCirList(head);

    // head = insertEnd1(head, 0);
    // printCirList(head);

    head = insertEnd2(head, 0);
    printCirList(head);

    }
}