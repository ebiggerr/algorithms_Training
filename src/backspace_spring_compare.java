public class backspace_spring_compare {

    /*
    *       Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
    *
    * */

    public static boolean backspaceCompare(String S, String T) {

        int s_index=S.length()-1;
        int t_index=T.length()-1;

        int skip_s=0;
        int skip_t=0;

        while( s_index >=0 || t_index >=0 ){

            while(s_index >=0){

                if(S.charAt(s_index) == '#'){
                    skip_s++;
                    s_index--;

                }
                else if(skip_s >0){
                    skip_s--;
                    s_index--;

                }
                else{
                    break;
                }
            }
            while(t_index >= 0 ){
                if(T.charAt(t_index)== '#'){
                    skip_t++;
                    t_index--;

                }
                else if(skip_t >0){
                    skip_t--;
                    t_index--;
                }
                else{
                    break;
                }
            }
            if( s_index>=0 && t_index >=0 && S.charAt(s_index) != T.charAt(t_index)){
                return false;

            }
            if( ( s_index>= 0 ) != ( t_index >=0 )){
                return false;
            }
            s_index--;
            t_index--;
        }
        return true;
    }

    public static void main(String [] args){

        String s1="ab#c";
        String s2="avd##c";

        System.out.println(backspaceCompare(s1,s2));

    }
}
