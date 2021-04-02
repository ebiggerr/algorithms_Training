public class valid_perfect_square {

    //check if the given integer num is perfect square or not

    //example
    //input : 16
    //output : true

    public boolean isPerfectSquare(int num){

        //newton method
        long t = num;

        while (t * t > num) {
            t = (t + num / t) / 2;
        }
        return t * t == num;
    }

    public  static void main(String [] args){
        valid_perfect_square v= new valid_perfect_square();

        System.out.println(v.isPerfectSquare(16));
    }
}
