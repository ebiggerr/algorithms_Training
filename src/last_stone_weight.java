import javax.lang.model.element.Element;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
* We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)



Example 1:

Input: [2,7,4,1,8,1]
Output: 1
Explanation:
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.*/

public class last_stone_weight {

    /**
     * @param stones array of the stones'weight
     * @return int - the weight of last stone or none if no stones are left
     */
    public static int lastStoneWeight(int[]stones){

        Queue<Integer> maxPq = new PriorityQueue<>(stones.length, Comparator.reverseOrder());
        for (int stone : stones) {
            maxPq.add(stone);
        }
        while (maxPq.size() >= 2) {

            int y = maxPq.poll();
            int x = maxPq.poll();
            if (y > x) {
                maxPq.add(y - x);
            }
        }
        return maxPq.isEmpty() ? 0 : maxPq.peek();


    }

    public static void main(String [] args){

        int [] stones={8,8};

        System.out.println(lastStoneWeight(stones));
    }

}
