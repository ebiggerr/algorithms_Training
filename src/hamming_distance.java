public class hamming_distance {

    /*
    * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

        Given two integers x and y, calculate the Hamming distance.
    *
    * */

    public int hammindDistance(int x,int y){
        int d = 0;
        int bitxor = x ^ y;

        while (bitxor > 0){
            /*if (bitxor % 2 == 1){
                d++;
            }*/
            d += bitxor % 2; //replace the function of line 8 to line 10

            bitxor = bitxor >> 1;
        }

        return d;
    }

    public static void main(String [] args){
        hamming_distance h=new hamming_distance();

        System.out.println(h.hammindDistance(1,4));
    }
}
