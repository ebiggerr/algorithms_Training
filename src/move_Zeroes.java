import java.util.Arrays;

public class move_Zeroes {

    /*
    * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Example:

    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]
* */

    public static void main (String []args){

        int []arr={1,2,0,4,5,1,0,0,1,0};

        System.out.println("Before move Zeroes: ");
        System.out.println(Arrays.toString(arr));
        moveZeroes(arr);

        System.out.println("After move Zeroes:");
        System.out.println(Arrays.toString(arr));



    }

    public static void moveZeroes(int []arr){
        int count=0;
        int index=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i] != 0){
                arr[count++]=arr[i];
            }
        }
        while(count<arr.length){
            arr[count++]=0;
        }

    }
}
