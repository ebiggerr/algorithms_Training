import static java.lang.Math.abs;

public class perform_string_shifts {

    /*
    *
    * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:

direction can be 0 (for left shift) or 1 (for right shift).
amount is the amount by which string s is to be shifted.
A left shift by 1 means remove the first character of s and append it to the end.
Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
Return the final string after all operations.



Example 1:

Input: s = "abc", shift = [[0,1],[1,2]]
Output: "cab"
Explanation:
[0,1] means shift to left by 1. "abc" -> "bca"
[1,2] means shift to right by 2. "bca" -> "cab"
Example 2:

Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
Output: "efgabcd"
Explanation:
[1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
[1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
[0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
[1,3] means shift to right by 3. "abcdefg" -> "efgabcd"


Constraints:

1 <= s.length <= 100
s only contains lower case English letters.
1 <= shift.length <= 100
shift[i].length == 2
0 <= shift[i][0] <= 1
0 <= shift[i][1] <= 100
*
* */

    public static String stringShift(String s,int [][]shift) {


        //shorter code

        /*int pos = 0, len = s.length();
        for (int[] sh : shift) {
            pos += sh[0] == 0 ? sh[1] : -sh[1];
        }
        pos = (pos % len + len) % len;
        return s.substring(pos) + s.substring(0, pos);*/

        //longer version

        int totalShift=0;

        for(int i=0;i<shift.length;i++){

            int direction=shift[i][0];
            int amount =shift[i][1];

                if(direction ==0 ){
                    totalShift -=amount;

                }
                else{
                    totalShift += amount;

                }
        }

        String new_Front="";
        String new_Rear="";


        //substr(pos,len) c++
        //two parameter
        // pos - starts at character position pos
        //len -spans len characters (or until the end of the string,whichever comes first

        //substring(beginIndex,endIndex) java
        //two parameter
        //beginIndex - the name describes it.
        //endIndex - same here

        if(totalShift <0 ){
            totalShift= abs(totalShift) % s.length();

            new_Front= s.substring(totalShift);
            int EndIndex= totalShift;
            new_Rear=s.substring(0,EndIndex);

        }
        else if(totalShift > 0){
            totalShift= totalShift % s.length();

            //int front_beginIndex= 0 ;
            int front_endIndex= 0 ;

            // (s.length-totalShift = pos
            //totalShift = len

            //convert to java implementation
            //  beginIndex=pos
            //  endIndex= pos+len

            front_endIndex=s.length();

            // cpp implementation
            //new_Front=s.substring( (s.length()-totalShift) ,totalShift);

            //to java
            new_Front=s.substring( (s.length()-totalShift) , front_endIndex );

            // 0 = pos
            // (s.length-totalShift) = len

            //convert to java implementation
            //

            new_Rear=s.substring(0, (s.length()-totalShift) );

        }
        else{
            return s;
        }
        return new_Front+new_Rear;
    
    }

    public static void main( String [] args){

        String s="abc";
        int [][]shift={{0,1},{1,2}};

        System.out.println(stringShift(s,shift));


    }
}
