import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class happy_number {

/*
    Write an algorithm to determine if a number is "happy".

    A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

    Example:

    Input: 19
    Output: true
    Explanation:
            1^2 + 9^2 = 82
            8^2 + 2^2 = 68
            6^2 + 8^2 = 100
            1^ + 0^2 + 0^2 = 1
    */


        public static boolean isHappy(int n) {

            Set<Integer> happy_num=new HashSet<Integer>();

            while(happy_num.add(n)){
                int sum=0;

                while(n>0){
                    sum +=Math.pow(n%10,2);
                    n/=10;

                }n=sum;

            }return n==1;
        }

        public static void main(String []args){
        boolean status=true;

            do{
                System.out.println("Input a number to identify whether it is happy number or not.");
                int input = new Scanner(System.in).nextInt();
                System.out.println(isHappy(input) ? "Happy Number" : "Not Happy Number");

                System.out.println("Stop the program? 1(Yes) 2(No)");
                input= new Scanner(System.in).nextInt();

                switch (input){
                    case 1:status=false;
                    break;

                    case 2:status=true;
                    break;


                }

            }while(status);

        }
    }

