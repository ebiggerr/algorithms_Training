import java.util.HashSet;
import java.util.Set;

public class Jewels_and_Stones {

    /*      You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

            The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

            Example 1:

            Input: J = "aA", S = "aAAbbbb"
            Output: 3

            Example 2:

            Input: J = "z", S = "ZZ"
            Output: 0

            Note:

            S and J will consist of letters and have length at most 50.
            The characters in J are distinct.


    *
    *
    * */

    public int numJewelsInStones(String J, String S) {
        int res = 0;
        Set setJ = new HashSet();
        for (char j: J.toCharArray()) {
            setJ.add(j);
        }
        for (char s: S.toCharArray()) {
            if (setJ.contains(s)) {
                res++;
            }
        }
        return res;
    }

    public static void main(String [] args){

        Jewels_and_Stones j=new Jewels_and_Stones();

        String a="aA";

        String b="aAABBBbb";

        System.out.println(j.numJewelsInStones(a,b));
    }

}
