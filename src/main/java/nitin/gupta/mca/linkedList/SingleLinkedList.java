package nitin.gupta.mca.linkedList;

public class SingleLinkedList <T extends Comparable<T>>{

    private Node<T> head ,tail;

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
         while (node!=null){
             System.out.print(node);
             node= node.next;
         }
     }
     public void addAtFirst(T data){
         Node<T>  node = head;
         Node<T> newNode= new Node<>(data);
         if(node==null){
             head=newNode;
         }else {
             newNode.next=head;
             head=newNode;
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
    }
}
