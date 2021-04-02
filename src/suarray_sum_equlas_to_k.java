import java.util.HashMap;
import java.util.Map;

public class suarray_sum_equlas_to_k {

    /*
    *       Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2

Note:

    The length of the array is in range [1, 20,000].
    The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

    *
    * */

    /*


    Solution 2. From solution 1, we know the key to solve this problem is SUM[i, j].
    So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j]. To achieve this, we just need to go through the array,
    calculate the current sum and save number of all seen PreSum to a HashMap. Time complexity O(n), Space complexity O(n).
    * */

    /*
    * The idea behind this approach is as follows: If the cumulative sum(repreesnted by sum[i]sum[i]sum[i] for sum upto ithi^{th}ith index) upto two indices is the same, the sum of the elements lying in between those indices is zero.
    * Extending the same thought further, if the cumulative sum upto two indices, say iii and jjj is at a difference of kkk i.e. if sum[i]−sum[j]=ksum[i] - sum[j] = ksum[i]−sum[j]=k, the sum of elements lying between indices iii and jjj is kkk.

        Based on these thoughts, we make use of a hashmap "map" which is used to store the cumulative sum upto all the indices possible along with the number of times the same sum occurs. We store the data in the form: (sumi,no.ofoccurencesofsumi)(sum_i, no. of occurences of sum_i)(sumi​,no.ofoccurencesofsumi​).
*       We traverse over the array "nums" and keep on finding the cumulative sum. Every time we encounter a new sum, we make a new entry in the hashmap corresponding to that sum. If the same sum occurs again, we increment the count corresponding to that sum in the hashmap.
*       Further, for every sum encountered, we also determine the number of times the sum "sum-k"" has occurred already, since it will determine the number of times a subarray with sum kkk has occured upto the current index. We increment the countcountcount by the same amount.

        After the complete array has been traversed, the "count" gives the required result.
    *
    * */

    public int subarraySum(int []nums,int k){
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

    public static void main(String [] args){

        int []arr={1,2,1,1,2};
        int target=3;

        suarray_sum_equlas_to_k s=new suarray_sum_equlas_to_k();

        System.out.println(s.subarraySum(arr,target));
    }
}
