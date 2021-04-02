import java.util.*;
import java.util.stream.Stream;

public class group_Anagrams {

    /*
    *   Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
    *
    *
    * */

    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs==null || strs.length==0){
            return new ArrayList<>();
        }

        Map<String,List<String>> map=new HashMap<>();

        for(String string : strs){

            char[]alphabet=new char[26];

                for(char c : string.toCharArray()){
                    alphabet[c-'a']++;
                }

                String keyString=String.valueOf(alphabet);

                    if( !map.containsKey(keyString)) {
                        map.put(keyString,new ArrayList<>());
                    }

                    map.get(keyString).add(string);

        }
        return new ArrayList<>(map.values());
    }

    public static void main(String [] args){

        String[]string_arr={"eat", "tea", "tan", "ate", "nat", "bat"};

        group_Anagrams gp1=new group_Anagrams();
        List<List<String>>gp2= gp1.groupAnagrams(string_arr);

        Stream.of(gp2.toArray()).forEach(System.out::println);
    }
}
