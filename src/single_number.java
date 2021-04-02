public class single_number {

   /* Given a non-empty array of integers, every element appears twice except for one. Find that single one.

    Note:

    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

    Example 1:
    Input: [2,2,1]
    Output: 1

    Example 2:
    Input: [4,1,2,1,2]
    Output: 4
*/
    public static void main(String []args){
        int []arr={1,2,3,4,2,3,1,5,5};
        System.out.println(singleNumber(arr));
    }

    public static int singleNumber(int []arr){
        int length=arr.length;

        int res=-1;
        if(length>1){
            res=arr[0];
            for(int i=1;i<length;++i){
                res=res^arr[i];
            }

        }
        else if(length==1){
            res=arr[0];
        }
        else{
            res=-2; //error code -2

        }return res; //error code -1 : all the numbers in the array appears twice or above.
    }

}
