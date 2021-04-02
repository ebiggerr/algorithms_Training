import java.util.HashMap;
import java.util.Map;

public class first_unique_number {

    /*
    *       You have a queue of integers, you need to retrieve the first unique integer in the queue.

            Implement the FirstUnique class:

                FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
                int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
                void add(int value) insert value to the queue.

            Example 1:
            Input:
            [“FirstUnique”,”showFirstUnique”,”add”,”showFirstUnique”,”add”,”showFirstUnique”,”add”,”showFirstUnique”]
            [[[2,3,5]],[],[5],[],[2],[],[3],[]]
            Output:
            [null,2,null,2,null,3,null,-1]

            Explanation:
            FirstUnique firstUnique = new FirstUnique([2,3,5]);
            firstUnique.showFirstUnique(); // return 2
            firstUnique.add(5);            // the queue is now [2,3,5,5]
            firstUnique.showFirstUnique(); // return 2
            firstUnique.add(2);            // the queue is now [2,3,5,5,2]
            firstUnique.showFirstUnique(); // return 3
            firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
            firstUnique.showFirstUnique(); // return -1

            Example 2:
            Input:
            [“FirstUnique”,”showFirstUnique”,”add”,”add”,”add”,”add”,”add”,”showFirstUnique”]
            [[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
            Output:
            [null,-1,null,null,null,null,null,17]

            Explanation:
            FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
            firstUnique.showFirstUnique(); // return -1
            firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
            firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
            firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
            firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
            firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
            firstUnique.showFirstUnique(); // return 17

            Example 3:
            Input:
            [“FirstUnique”,”showFirstUnique”,”add”,”showFirstUnique”]
            [[[809]],[],[809],[]]
            Output:
            [null,809,null,-1]

            Explanation:
            FirstUnique firstUnique = new FirstUnique([809]);
            firstUnique.showFirstUnique(); // return 809
            firstUnique.add(809);          // the queue is now [809,809]
            firstUnique.showFirstUnique(); // return -1

            Constraints:

            1 <= nums.length <= 10^5
            1 <= nums[i] <= 10^8
            1 <= value <= 10^8
            At most 50000 calls will be made to showFirstUnique and add.

    *
    *
    * */



    private class ListNode{

        ListNode _next;
        ListNode _prev;

        int _val;

        public ListNode(int value){
            _val=value;
            _next=null;
            _prev=null;
        }
    }

    private class D_LinkedList{

        private ListNode _head;
        private ListNode _tail;

        public D_LinkedList(){

            _head=new ListNode(-1);
            _tail=new ListNode(-1);

            _head._next= _tail;
            _tail._prev= _head;

        }

        public ListNode getFirst(){
            return _head._next;
        }

        public boolean isEmpty(){
            return _head._next == _tail;
        }

        public void remove(ListNode node){

            ListNode prev=node._prev;
            ListNode next=node._next;

            prev._next= next;
            next._prev= prev;
        }

        public ListNode append(int num){

            ListNode node=new ListNode(num);
            ListNode prev=_tail._prev;
            prev._next=node;
            node._next=_tail;
            _tail._prev=node;
            node._prev=prev;

            return node;
        }
    }


    private D_LinkedList keys;
    private Map<Integer,ListNode> map;

    public first_unique_number(int[] nums){
        map=new HashMap<>();
        keys=new D_LinkedList();

        for(int n : nums){
            add(n);
        }

    }

    public int showFirstUnique(){
        if(keys.isEmpty()){
            return -1;
        }
        return keys.getFirst()._val;
    }

    public void add(int value){

        if(map.containsKey(value)){

            if(map.get(value) != null){
                keys.remove(map.get(value));
                map.put(value,null);
            }
        }
        else{
            ListNode node=keys.append(value);
            map.put(value,node);
        }

    }

    public static void main(String [] args){

        int [] nums={1,2,3};

        first_unique_number f1=new first_unique_number(nums);

        System.out.println(f1.showFirstUnique());

        f1.add(1);



        System.out.println(f1.showFirstUnique());

    }
}
