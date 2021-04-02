import java.util.HashMap;
import java.util.Map;

public class ransom_note {

    /*
    *    Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

        Each letter in the magazine string can only be used once in your ransom note.

        Note:
        You may assume that both strings contain only lowercase letters.

        canConstruct("a", "b") -> false
        canConstruct("aa", "ab") -> false
        canConstruct("aa", "aab") -> true


    *
    *
    * */

    public boolean canConstruct(String ransomNote,String magazine){

        Map<Character,Integer> mag_map=new HashMap<>();
        int count=0;


        for(char cha : magazine.toCharArray()){
            if( mag_map.containsKey(cha) ){
                count= mag_map.get(cha) + 1;
                mag_map.put(cha,count);
            }
            else{
                mag_map.put(cha,1);
            }
        }
        for(char C : ransomNote.toCharArray()){
            if( !mag_map.containsKey(C) ){
                return false;

            }
            count=mag_map.get(C);

            if( count == 0 ){
                return false;
            }

            mag_map.put(C,count-1);
        }
        return true;


        /* using ASCII 
           int[] arr = new int[26];
            for (int i = 0; i < magazine.length(); i++) {
                arr[magazine.charAt(i) - 'a']++;
            }
            for (int i = 0; i < ransomNote.length(); i++) {
                if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                    return false;
                }
            }
            return true;
         */
    }

    public static void main(String [] args){

        ransom_note r= new ransom_note();

        String ransomeNote="aA";

        String Magazine="AFJJEAEWaeewewfgrAa";

        System.out.println(r.canConstruct(ransomeNote,Magazine));
    }
}
