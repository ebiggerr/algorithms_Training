    /*      Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

            push(x) -- Push element x onto stack.
            pop() -- Removes the element on top of the stack.
            top() -- Get the top element.
            getMin() -- Retrieve the minimum element in the stack.


            Example:

            MinStack minStack = new MinStack();
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);
            minStack.getMin();   --> Returns -3.
            minStack.pop();
            minStack.top();      --> Returns 0.
            minStack.getMin();   --> Returns -2.
            */
public class min_stack {

    int minValue = Integer.MAX_VALUE;
    Node head = null;

        public void push(int x) {
        minValue = x < minValue ? x : minValue;
        Node node = new Node(x, minValue, head);
        head = node;
    }

    public void pop() {
        if(head.next == null) {
            head = null;
            minValue = Integer.MAX_VALUE;
        } else {
            head = head.next;
            minValue = head.minValue;
        }
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        return head.minValue;
    }

    public void printList(){

            if(head==null) throw new RuntimeException("Stack Underflow");

            else{
                Node temp=head;
                while(temp != null){
                    System.out.printf("%d->",temp.value);

                    temp=temp.next;
                }
                System.out.println();
            }
        }


    class Node {

        int value;
        Node next;
        int minValue;

        public Node(int value, int minValue, Node next) {
            this.value = value;
            this.minValue = minValue;
            this.next = next;
        }
    }

    public static void main(String []args){

        min_stack stack=new min_stack();
        stack.push(2);;
        stack.push(5);
        stack.push(7);
        stack.push(100);
        stack.push(12);

        stack.printList();

        int current_top=stack.top();
        System.out.println("Current Top = " + current_top);

        System.out.println("Currentt top in the stack is " + stack.top());

        stack.pop();

        System.out.println("Current Min in the stack is "+ stack.getMin());

        stack.printList();

    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */