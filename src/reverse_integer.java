public class reverse_integer {

    public static void main( String [] args){

        //int input = 2147483647;//overflow test case
        int input = 123;

        System.out.println(reverse_the_integer(input));

    }

    public static int reverse_the_integer(int input){

        int result=0;

        while( input != 0 ){

            int remainder = input % 10;
            int new_result = result * 10 + remainder;

            //handle overflow
            if( new_result /10 != result ){ return 0;}
            //if( ( new_result - remainder ) / 10 != result ) return 0;

            /*
            *
            * For your reference, to test if there is overflow for any integer x of the form x = a * 10 + b where |b| < 10,
            * the right way should be comparing x / 10 (integer division) with a. If x / 10 != a, there is overflow,
            * otherwise no overflow can happen. The proof is as follows: first note that x itself is a signed integer,
            * therefore we have INT_MIN <= x <= INT_MAX, which implies INT_MIN/10 <= x/10 <= INT_MAX/10.
            *  So if we assume x / 10 == a, we have INT_MIN/10 <= a <= INT_MAX/10. Since |b| < 10,
            * then a * 10 + b can overflow only if a = INT_MAX/10 or a = INT_MIN/10. For signed 32-bit integers, we have INT_MAX = 2147483647 and INT_MIN = -2147483648.
            * For a = INT_MAX/10 = 214748364, overflow will happen only if b = 8 or 9. However if this is the case,
            *  then x = a * 10 + b will be negative and x / 10 cannot be the same as a, contradicting our assumption above.
            * Similarly if a = INT_MIN/10 = -214748364, overflow will happen only if b = -9 but then x = a * 10 + b will be positive
            * and again x / 10 won't be equal to a. In summary, x / 10 != a <==> overflow.

            As for the test condition in the original post, which is equivalent to testing (x - b) / 10 != a, it will only
            * cover the cases when |a| > INT_MAX/10 but not the cases when |a| = INT_MAX/10, b = 8 or 9 for positive a and -9 for negative a.
            * The test condition works here because the edge cases mentioned above won't happen due to the fact that the input itself is a signed integer.
            *  If the input is something else, say a string (see String to Integer (atoi)), the test condition above will fail the edge cases.*/

            result = new_result;
            input /= 10;
        }



        return result;

    }
}
