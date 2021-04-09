import java.util.HashSet;

public class palindrome {

    public static boolean isPalindrome(String text, String trashSymbols){
        //System.out.println("Original Text: " + text);

        //return check( removeTrash(text, trashSymbols) );

        return checkv2(text,trashSymbols);
    }

    public static boolean check(String text){

        char[] c = text.toCharArray();
        for (int i = 0, j = c.length - 1; i < j; ) {
            if (!Character.isLetterOrDigit(c[i])) i++;
            else if (!Character.isLetterOrDigit(c[j])) j--;
            else if (Character.toLowerCase(c[i++]) != Character.toLowerCase(c[j--]))
                return false;
        }
        return true;

    }

    public static boolean checkv2(String text,String trashSymbols){

        //allocate all the trash symbols in a hash set
        HashSet<Character> trashSet = new HashSet<>();

        for( int index=0; index < trashSymbols.length(); index++){
            trashSet.add(trashSymbols.charAt(index));
        }

        for (int i = 0, j = text.length() - 1; i < j; ) {

            //truth table
            // true AND false == false

            if ( (!Character.isLetterOrDigit( text.charAt(i) ) ) && trashSet.contains( text.charAt(i) )  ) i++; // increment the head pointer

            //
            else if ( (!Character.isLetterOrDigit( text.charAt(j) ) ) && trashSet.contains( text.charAt(j) ) ) j--; // move the tail pointer forwards


            else if (Character.toLowerCase( text.charAt(i++) ) != Character.toLowerCase( text.charAt(j--) ))
                return false;
        }

        return true;

    }

    public static String removeTrash(String text, String trashSymbols){

        HashSet<Character> trashSet = new HashSet<>();

        StringBuilder builder = new StringBuilder();

        for( int index=0; index < trashSymbols.length(); index++){
            trashSet.add(trashSymbols.charAt(index));
        }

        for( int index=0; index < text.length(); index++){

            if(trashSet.contains(text.charAt(index))){
                //do nothing

            }else{
                //append the char if it is not a member of the 'trashSymbols' set
                builder.append(text.charAt(index));
            }
        }
        System.out.println("Cleaned Up: " + builder);
        return builder.toString();
    }

    public static void main(String[] args) {

        //System.out.println(isPalindrome("Ca@b!!b#aDc","!C@$#"));

        System.out.println(isPalindrome("!c@A#a@c","#@")); // ignoring trash => !cAac thus false
        System.out.println(isPalindrome("!c@A#a@c","!")); // ignoring trash => c@A#a@c thus true
        System.out.println(isPalindrome("!c@A#a@c","!#@")); // ignoring trash => cAac thus true

    }

}
