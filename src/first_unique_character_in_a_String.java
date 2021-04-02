import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class first_unique_character_in_a_String {

    /*
    *    Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

        Examples:

        s = "leetcode"
        return 0.

        s = "loveleetcode",
        return 2.

        Note: You may assume the string contain only lowercase letters.
    *
    *
    * */

    /**
     *
     * @param s String
     * @return int - the index of the first unique character
     */

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                if (map.get(s.charAt(i)) != null) {
                    map.remove(s.charAt(i));
                }
            } else {
                map.put(s.charAt(i), i);
                set.add(s.charAt(i));
            }
        }
        return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
    }

    public static void main(String [] args){

        first_unique_character_in_a_String f=new first_unique_character_in_a_String();

        String s="aaaeeeebbbddseecccsddddeeeeegffddffwwwaasddkkkll";

        int index=f.firstUniqChar(s);

        System.out.println(index);

        System.out.println(s.charAt(index));


    }


}
