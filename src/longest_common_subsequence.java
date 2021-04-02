public class longest_common_subsequence {


    /*
    *   Given two strings text1 and text2, return the length of their longest common subsequence.

        A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters.
        * (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.



        If there is no common subsequence, return 0.
    *
    * */

    // Illustration

    //      0 1 2
    //     "" a b str1
    // 0 "" 0 0 0
    // 1 a  0 1 1
    // 2 z  0 1 1
    // 3 b  0 1 2
    //   str2

    /**
     *
     * @param text1 -String a
     * @param text2 -String b
     * @return int the number of common subsequence character between two String text1, and String text2
     *
     */
    public int longestCommonSubsequence(String text1, String text2) {
        // if 2nd string is smaller - replace params
        if (text2.length() > text1.length())
            return longestCommonSubsequence(text2, text1);

        int cols = text1.length(), rows = text2.length();

        // create array of min string length
        int[] lcs = new int[cols+1];

        // start iterating over rows / cols, skip 1st row and col as they all 0s
        for (int r = 1; r < rows+1; r++) {

            // init diag val
            int diag = 0;

            for (int c = 1; c < cols+1; c++) {

                // save cur val to use as diag for the next val
                int nextDiag = lcs[c];

                if (text1.charAt(c-1) == text2.charAt(r-1)) {
                    // if same chars take diag + 1
                    lcs[c] = diag + 1;

                } else {
                    // else take max of upper (old val in the same cell) or left val
                    lcs[c] = Math.max(lcs[c], lcs[c-1]);
                }

                // update diag with the saved one
                diag = nextDiag;
            }
        }

        // return bottom right val
        return lcs[cols];
    }


    public static void main(String [] args){
        longest_common_subsequence l=new longest_common_subsequence();

        String string1="abc";
        String string2="bc";

        System.out.println(l.longestCommonSubsequence(string1,string2));



    }
}
