//implementation of Stack using Linked List
public class stack {


    private class Node{

        int data;

        //reference link to next node
        //same as linked list's next (pointer in linked list)
        Node link;


    }
    //global top reference variable
    Node top;

    //constructor
    stack(){
        this.top=null;

    }

    /*
        push new node on the top of the stack
        Time complexity is O(1)
        @param int data- data of the node
     */
    void push(int data){
        Node temp=new Node();

        if(temp==null) throw new StackOverflowError("Heap Overflow");

        //assign the data to the data of new node -temp
        temp.data=data;

        // temp ->(link)  top
        temp.link=top;

        //the temp which is the new top to the stack
        top=temp;
    }

    /*
        check if the stack is empty
        @return boolean
     */
    boolean isEmpty(){
        return (top==null);
    }


    /*
        @return the top element of the stack
     */
    int peek(){
        if(!isEmpty()){
            return top.data;
        }
        else{
            System.out.println("Stack is empty");
            return -1;
        }

    }

    /*
        remove the top element in the stack

     */
    int pop(){

        if(top==null) throw new RuntimeException("Stack Underflow");

        //
        top=(top).link;


        return top.data;
    }

    void printList(){

        if(top==null) throw new RuntimeException("Stack Underflow");

        else{
            Node temp=top;
            while(temp != null){
                System.out.printf("%d->",temp.data);

                temp=temp.link;
            }
            System.out.println();
        }
    }

    public static void main(String [] args){

        stack stack=new stack();

        int input;
        input=23132;


        while(input != 0){
            int r=input%2;
            stack.push(r);
            input /=2;

        }

        System.out.println("Output");
        stack.printList();

        while(!stack.isEmpty()){
            System.out.print(stack.pop());

            //the NullPointerException is due to the top=(top).link
            //when the stack only have one element left,
            //the top.link is null
            //therefore the return of the pop() method in the last round carry a null
            //causing the NullPointerException
            //the pop() method have to be fixed to handle this exception
            
        }

        System.out.println();
    }

}



