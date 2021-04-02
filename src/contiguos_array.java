import java.util.HashMap;
import java.util.Map;

/*Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:

Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Example 2:

Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
*/
public class contiguos_array {

    public static int findMaxLength(int []nums){

        int maxLength=0;
        int count=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                nums[i]=-1;
            }
        }

        Map<Integer,Integer> map_sumToIndex = new HashMap<>();
        map_sumToIndex.put(0,-1);

        for(int i=0;i<nums.length;i++){
            count += nums[i];
            if(map_sumToIndex.containsKey(count)){
                maxLength=Math.max( maxLength , i-map_sumToIndex.get(count));
            }
            else{
                map_sumToIndex.put(count,i);
            }
        }

        return maxLength;
    }

    public static void main(String [] args){

        int []arr={0,1,1,1,0,1,0,0,1,0,1,0,1,0,1,0,1};

        System.out.println("Max Length of the Contiguous Array is "+ findMaxLength(arr));
    }
}
