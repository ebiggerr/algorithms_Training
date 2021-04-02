import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class counting_elements {

    /*
    * Given an integer array arr, count element x such that x + 1 is also in arr.

If there're duplicates in arr, count them seperately.



Example 1:

Input: arr = [1,2,3]
Output: 2
Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
Example 2:

Input: arr = [1,1,3,3,5,5,7,7]
Output: 0
Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
Example 3:

Input: arr = [1,3,2,3,5,0]
Output: 3
Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
Example 4:

Input: arr = [1,1,2,2]
Output: 2
Explanation: Two 1s are counted cause 2 is in arr.*/
    public static int countElements(int []arr){

        //first attempt
        /*if(arr==null || arr.length==0){
            return -1;
        }

        HashSet<Integer>h=new HashSet<Integer>();
        int diff=0;
        int count=0;
        for(int i=0;i<arr.length;i++){

           if(h.contains(arr[i]-1)){
                count++;
           }
            if(h.contains(arr[i]+1)){
                count++;
            }
            h.add(arr[i]);
        }
        return count;*/

        //solution using HashSet
        int n = arr.length;
        //Arrays.sort(arr);
        HashSet<Integer> h = new HashSet<>();
        for(int i=0;i<n;i++){
            h.add(arr[i]);
        }

        int count = 0;
        for(int j=0;j<n;j++){
            if(h.contains(arr[j]+1)){
                count++;
            }
        }
        return count;


        /*int temp;
        int count=0;
        int beg;
        int mid;
        int end;
        int midVal;
        Arrays.sort(arr);

        for(int i=0;i<arr.length-1;i++){

            //difference wanted between pair is 1
            temp=arr[i]+1;
            beg=i+1;
            end=arr.length-1;

            for(int l=beg;l<arr.length;l++){
                mid=(beg+end)/2;
                midVal=arr[mid];

                if(midVal==temp){
                    count++;
                    break;
                }
                else if(midVal>temp){
                    end=mid-1;
                }
                else{
                    beg=mid+1;
                }
            }

        }
        return count;*/
    }



    public static void main(String [] args){

        //int[]arr={1,2,3,5,7,9};
        int []arr={2,1,3,7,4,9};

        System.out.println(countElements(arr));


    }
}
