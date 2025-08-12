package nitin.gupta.mca.linkedList;

public class SingleLinkedList <T extends Comparable<T>>{

    private Node<T> head ,tail;

    public void deleteAtFirst() {
        if(head==null) return ;
        else {
            Node<T> node =head;
            Node<T> nodeNext=node.ne\xt;

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

    public void deleteAtMiddle() {
        if(head==null) return;
        else {
            Node<T> node =head;
            if(node.next==null) head=tail=null;
            else if(node.next!=null && node.next.next==null) {
                head=tail=node.next;
                node=null;
            }else {
                Node<T> beforeMiddle = getBeforeOneNodeMiddleNode();
                    beforeMiddle.next = beforeMiddle.next.next;
            }
        }
    }

    public void AddElementInPosition(T data, int position) throws IllegalAccessException {
        if(head==null) return;
        else {
            Node<T> newNod= new Node<>(data);
            Node<T> node =head;
            if(position==0){
                newNod.next=head;
                head=newNod;
            }else if(position==1){
                newNod.next=head.next;
                head.next=newNod;
            }else {
                int count = 0;
                while (node != null && count < position - 1) {
                    node = node.next;
                    count++;
                }
                if (node == null) throw new IllegalAccessException("List don't have number of node");
                else {
                    Node<T> current = node;
                    Node<T> nextToCurrent = node.next;
                    current.next = newNod;
                    newNod.next = nextToCurrent;
                }
            }
        }
    }

    public void deleteElementInPosition(int position) throws IllegalAccessException {
        if(head==null) return;
        else {
            Node<T> node= head;
            if(position==0){
                head=node.next;
                node=null;
            }else {
                int count=1;
                while (node!=null && count <position-1){
                    node=node.next;
                    count++;
                }
                if(node==null) throw new IllegalAccessException("number of elements not present in the list");
                else{
                    Node<T> tmp =node;
                    tmp.next = tmp.next.next;
                }

            }
        }
    }

    public void insertAtPositionFromLast(T data, int position) {
        if(head==null)return;
        Node<T> node =head;
        Node<T> newNode =new Node<>(data);
        if(position==0){
            addAtLast(data);
        }else{
            int count =1;
            Node<T> temp =head;
            while (node!=null){
                if(count<=position) {
                    node = node.next;
                    count++;
                }else{
                   node=node.next;
                   temp =temp.next;
                   count++;
                }
            }
            Node<T> ptr= temp;
            Node<T> ptrNext= temp.next;
            ptr.next=newNode;
            newNode.next=ptrNext;
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
        if (head == null) return null;
        else {
            Node<T> slowPointer = head;
            Node<T> fasterPointer = head.next.next;
            while (slowPointer != null && fasterPointer != null) {
                slowPointer = slowPointer.next;
                fasterPointer = fasterPointer.next;
                if (fasterPointer != null) fasterPointer = fasterPointer.next;
            }
            return slowPointer;
        }
    }

        private Node<T> getBeforeOneNodeMiddleNode() {
            if(head==null)return null;
            else {
                Node<T> slowPointer =head;
                Node<T> fasterPointer =head.next.next.next;
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
    public static void main(String[] args) throws IllegalAccessException {
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        sll.addAtFirst(10);
        sll.addAtFirst(20);
        sll.addAtFirst(30);
        sll.AddElementInPosition(15, 0);
        sll.AddElementInPosition(20, 1);
        sll.AddElementInPosition(44, 2);
        sll.addAtLast(40);
        sll.addAtLast(50);
        sll.addAtLast(60);
        sll.print();
        sll.addAtFirst(10);
        sll.addAtFirst(20);
        sll.addAtFirst(30);
        sll.AddElementInPosition(15, 0);
        sll.AddElementInPosition(20, 1);
        sll.AddElementInPosition(44, 2);
        sll.addAtLast(40);
        sll.addAtLast(50);
        sll.addAtLast(60);
        sll.print();
        sll.deleteDuplicateElement();
        sll.print();
        /*sll.insertAtPositionFromLast( 55 ,0);
        sll.print();
        sll.insertAtPositionFromLast( 88 ,8);
        sll.print();
        sll.insertAtPositionFromLast( 44 ,4);
        sll.print();
        sll.insertAtPositionFromLast( 0 ,14);
        sll.print();*/
        /*sll.print();
        sll.addAtMiddle(15);
        sll.addAtMiddle(25);
        sll.addAtMiddle(35);*/
       /* sll.print();
        sll.deleteElementInPosition(0);
        sll.print();
        sll.deleteElementInPosition(8);
        sll.print();
        sll.deleteElementInPosition(4);
        sll.print();*/
        //sll.deleteAtFirst();
       // sll.deleteAtLast();
       // sll.deleteAtMiddle();
       // sll.print();
       // sll.deleteAtFirst();
        //sll.deleteAtLast();
        //sll.deleteAtMiddle();
        //sll.print();
        //sll.deleteAtFirst();
        ///sll.deleteAtLast();
       // sll.deleteAtMiddle();
       // sll.print();
        //sll.print();
        ///sll.print();
    }
}
