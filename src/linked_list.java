
public class linked_list{

    Node head;

    class Node{

        int data;
        Node next;

        //constructor
        Node(int data){
            this.data=data;
            next=null;

        }

    }

    /**  function: delete node with given data
       * @param data    data of the node
       * delete the first occurrence only
     */
    public void delete(int data){

       /*
            example: 1->2->3
            delete a node from the linked list

            3 exceptions to be handle
            -list is empty
            (Deletion cannot be performed)

            -the target node is the head node
            (new head will be the next of current head) - head=head.next;

            -the target node is not in the list
            (Deletion cannot be performed)

            Normal
            -  Head -> Prev -> Current -> Tail
        */
       //list is empty
       if(head==null)throw new RuntimeException("Cannot Delete,Empty List");

        //the target node is the head node
        // O(1)
        if(head.data == data){

            //point the next of head as the head
            head=head.next;
            //return
            //if not the head will become null
            return;
        }

        //Normal
        Node current=head;
        Node prev=null;

        //Time complexity O(n)
        //have to transverse through the linked list
        //There is a solution which can achieve O(1) but not this
        while(current != null && current.data != data){
            prev=current;
            current=current.next;
        }

        //Key is out of the linked list
        if(current==null)throw new RuntimeException("Key is not present.");

        //NullPointerException
        //assert prev != null;
        prev.next=current.next;

    }

    /**
        Delete node with given position in the linked list
        * @param position   nth position in the linked list the the target delete node
        * let say the position of the linked linked starts from 1 to make more sense rather than 0
     */
    void deleteNode(int position){

        //list is empty
        if(head==null)throw new RuntimeException("Cannot Delete,Empty List");

        //position is 0 (throw exception)
        //position starts from 1
        if(position==0)throw new RuntimeException("Invalid Position");

        //target is head node
        // O(1)
        if(position==1){

            /*      (Head)   (New head)
                             head.next
            LIST    Temp  ->  Current -   >  Next
             */

            Node temp=head;
            head=head.next;
            temp.next=null;
        }
        //target node is not the head node
        // O(n)
        else {

            //need to transverse through the linked list to get the previous node of the target node
            Node prev=head;

            int count=1;
            while(count<position-1){
                //transversing
                prev= prev.next;
                count++;

                //an alternative way to detect whether the position is out of bound from the linked list
                //if size() method is available then do not have to loop through to get the size
                if(position>count+2)throw new RuntimeException("Position Exceeded");

            }
            //current is the target node after transverse through the linked list
            Node current=prev.next;
            //point the next of the previous node to the next of the current node(which is the target delete node)
            prev.next=current.next;

            //remove the pointer of the target delete node to its next node
            current.next=null;

        }


    }

    void push(int data){
        Node new_node=new Node(data);

        //before push 1->2->3
        //point the original head as the new node next
        new_node.next=head;
        //after push 4(new node) -> 1(new node.next=head) before this line head is 1

        //point the new node as the head of the linked list
        head=new_node;
    }

    void printList(){

        //temp
        Node tempnode=head;

        //traverse through the linked list from head to last node
        while(tempnode != null ){
            System.out.print(tempnode.data+ " ");
            tempnode=tempnode.next;
        }
        System.out.println();
    }


    public static void main(String []args) {

        int target1=2;
        int target2=5;

        linked_list list=new linked_list();
        //The current list consists of  5 1 2 6  3 4  7

        list.push(7);
        list.push(4);
        list.push(3);
        list.push(6);
        list.push(2);
        list.push(1);
        list.push(5);

        list.printList();

        list.delete(target1);
        list.delete(target2);




        System.out.println("Deletion of " + target1 + " and " + target2);
        //System.out.println("Deletion of Node " + target1 + " and Node " + target2);

        list.printList();


        list.deleteNode(2);
        System.out.println("Deletion of Node 2");
        list.printList();

        list.deleteNode(4);
        System.out.println("Deletion of Node 4");
        list.printList();

    }


    }

