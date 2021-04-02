class maximum_subarray {

   /* Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

    Example:

    Input: [-2,1,-3,4,-1,2,1,-5,4],
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
    */


    public static int maxSubArray(int[] arr) {

        int arr_size = arr.length;
        int max_curr = Integer.MIN_VALUE, max_global = 0;

        for (int i = 0; i < arr_size; ++i)
        {
            max_global += arr[i];
            if (max_curr < max_global)
                max_curr = max_global;
            if (max_global < 0)
                max_global = 0;
        }
        return max_curr;
    }

    public static void main(String[] args){
        int [] arr = {-2,1};
        System.out.println("Maximum contiguous sum is " +
                maxSubArray(arr));
    }
}