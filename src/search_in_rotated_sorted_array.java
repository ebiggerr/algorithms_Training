public class search_in_rotated_sorted_array {

    /*
    *   Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1


    *
    * */

    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo == hi && nums[lo] == target ? lo : -1;
    }

    public static void main(String []args){

        //pre rotated array for simplicity on purpose of demonstration
        int []arr={4,5,6,7,8,9,1,2,3};
        int search_key=2;

        search_in_rotated_sorted_array s=new search_in_rotated_sorted_array();

        System.out.println(s.search(arr,search_key));

    }

    /*
    *
    *       My solutions use binary search guided by the following thoughts:

Remember the array is sorted, except it might drop at one point.

    If nums[0] <= nums[i], then nums[0..i] is sorted (in case of "==" it's just one element, and in case of "<" there must be a drop elsewhere). So we should keep searching in nums[0..i] if the target lies in this sorted range, i.e., if nums[0] <= target <= nums[i].

    If nums[i] < nums[0], then nums[0..i] contains a drop, and thus nums[i+1..end] is sorted and lies strictly between nums[i] and nums[0]. So we should keep searching in nums[0..i] if the target doesn't lie strictly between them, i.e., if target <= nums[i] < nums[0] or nums[i] < nums[0] <= target

Those three cases look cyclic:

    nums[0] <= target <= nums[i]
               target <= nums[i] < nums[0]
                         nums[i] < nums[0] <= target

So I have the three checks (nums[0] <= target), (target <= nums[i]) and (nums[i] < nums[0]), and I want to know whether exactly two of them are true. They can't all be true or all be false (check it), so I just need to distinguish between "two true" and "one true". Parity is enough for that, so instead of adding them I xor them, which is a bit shorter and particularly helpful in Java and Ruby, because those don't let me add booleans but do let me xor them.

(Actually while developing this I thought of permutations of nums[0], target and nums[i] and the permutation parity and saw those three checks as representing inversions, but I had trouble putting that into words and now find the above explanation much better. But it helped me get there, so I wanted to mention it here.)
    *
    * */
}
