import java.util.regex.Pattern;

public class defanging_an_IP_address {

    public String defangingIP(String address){
        return address.replaceAll("\\.","[.]");
    }

    public static void main(String [] args){

        String address="192.118.0.0";
        defanging_an_IP_address a=new defanging_an_IP_address();

        System.out.println(a.defangingIP(address));
        System.out.println(a.DefangingInC(address));

        /* C++ Implementation (easier to understand as the underlying mechanism is observable) at least better than replaceAll() in Java
        *
        *   for (int i = address.size() - 2; i >= 0; i--)
            if (address[i + 1] == '.')
                address = address.substr(0, i + 1) + "[.]" + address.substr(i + 2);
            return address;
            *

        *
        *
        * */

    }

    public String DefangingInC(String address){

        char[]charArr=new char[address.length()];


        //TODO Examine that whether using recursive method to convert the Address String or calling charAt(index) recursively is better
        for(int i =0;i<address.length();i++){
            charArr[i]=address.charAt(i);
        }

        for(int i=address.length()-2;i>=0;i--){

            //examine
             //if(address.charAt(i+1)== '.'){
            if( charArr[i+1] =='.'){
                address = address.substring(0, i + 1) + "[.]" + address.substring(i + 2);
            }
        }
        return address;
    }

}


