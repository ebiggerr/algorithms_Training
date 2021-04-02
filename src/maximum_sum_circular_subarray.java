public class maximum_sum_circular_subarray {

    /*
    *   Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.

Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)

Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)
    *
    *
    * */

    public int maxSubarraySumCircular(int[] A) {
        int total = 0, maxSum = -30000, curMax = 0, minSum = 30000, curMin = 0;
        for (int a : A) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;

        // ? : operator

        /*
        * equals to if maxSum > 0 then return Kath.max()
        * else return maxSum
        * */
    }

    public static void main(String [] args){

        maximum_sum_circular_subarray m=new maximum_sum_circular_subarray();

        int[]arr={0,2,1,5,3,6,1,2,4,9};

        System.out.println(m.maxSubarraySumCircular(arr));
    }

    /*
    *
    Intuition

    I guess you know how to solve max subarray sum (without circular).
    If not, you can have a reference here: 53. Maximum Subarray


    Explanation

    So there are two case.

    The first is that the subarray take only a middle part, and we know how to find the max subarray sum.
    The second is that the subarray take a part of head array and a part of tail array.
    We can transfer this case to the first one.
    The maximum result equals to the total sum minus the minimum subarray sum.

    Case 1
    maximum subarray is not circular

    [     ][-------------][          ]
    0       maximum subarray        N-1

    [     ][-------------][-----     ][     ][             ][          ]
    0           maximum subarray     N-1                                2N-1

    * equals
    [ MAX ][-------------][ Subarray ]
    0       Min subarray            N-1

    So the max subarray circular sum equals to
    max(the max subarray sum, the total sum- the mim subarray sum)

    Corner case

    Just one to pay attention:
    If all numbers are negative, maxSum = max(A) and minSum = sum(A).
    In this case, max(maxSum, total - minSum) = 0, which means the sum of an empty subarray.
    According to the description, We need to return the max(A), instead of sum of am empty subarray.
    So we return the maxSum to handle this corner case.

    Complexity

    One pass, time O(N)
    No extra space, space O(1)


    *
    *
    *
    * */
}

