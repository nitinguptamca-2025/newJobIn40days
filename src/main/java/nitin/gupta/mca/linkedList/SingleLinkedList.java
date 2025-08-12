package nitin.gupta.mca.linkedList;

public class SingleLinkedList <T extends Comparable<T>>{

    private Node<T> head ,tail;

    public void deleteAtFirst() {
        if(head==null) return ;
        else {
            Node<T> node =head;
            Node<T> nodeNext=node.next;
            head=nodeNext;
            node=null;
        }
    }

    public void deleteAtLast() {
        if(head==null) return;
        else {
            Node<T> node=head;
            while (node.next.next!=null) node=node.next;
            tail=node;
            node.next=null;
        }
    }

    static class Node<T extends Comparable<T>>{
         T data;
         Node<T> next;
         public Node(T data) {
             this.data = data;
         }

         @Override
         public String toString() {
             return " " + data +",";
         }
     }

     public void print(){
         Node<T> node =head;
         System.out.println();
         while (node!=null){
             System.out.print(node);
             node= node.next;
         }
     }
     public void addAtFirst(T data){
         Node<T>  node = head;
         Node<T> newNode= new Node<>(data);
         if(node==null){
             tail=head=newNode;
         }else {
             newNode.next=head;
             head=newNode;
         }
     }
     public void addAtLast(T data){
         Node<T> newNode = new Node<>(data);
         Node<T> currentNode=tail;
         if(currentNode==null){
             head=tail=newNode;
         }else {
             currentNode.next=newNode;
             tail=newNode;
         }
     }
     public void addAtMiddle(T data){
         Node<T> node= head;
         Node<T> newNode = new Node<>(data);
         if(head==null){
             head=tail= newNode;
         }else {
             Node<T> beforeMiddle=getBeforeMiddleNode();
             Node<T> middlePointer= beforeMiddle.next;
             beforeMiddle.next=newNode;
             newNode.next=middlePointer;
         }
     }

    private Node<T> getBeforeMiddleNode() {
         if(head==null)return null;
         else {
             Node<T> slowPointer =head;
             Node<T> fasterPointer =head.next.next;
             while(slowPointer!=null && fasterPointer!=null){
                     slowPointer=slowPointer.next;
                     fasterPointer=fasterPointer.next;
                     if(fasterPointer!=null) fasterPointer=fasterPointer.next;
             }
             return slowPointer;
         }
    }
}

class TestSingleLinkedList{
    public static void main(String[] args) {
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        sll.addAtFirst(10);
        sll.addAtFirst(20);
        sll.addAtFirst(30);
        sll.print();
        sll.addAtLast(40);
        sll.addAtLast(50);
        sll.addAtLast(60);
        sll.print();
        sll.addAtMiddle(15);
        sll.addAtMiddle(25);
        sll.addAtMiddle(35);
        sll.print();
        //sll.deleteAtFirst();
       // sll.deleteAtLast();
        sll.print();
       // sll.deleteAtFirst();
        //sll.deleteAtLast();
        sll.print();
        //sll.deleteAtFirst();
        ///sll.deleteAtLast();
        sll.print();
        //sll.print();

        ///sll.print();
    }
}
