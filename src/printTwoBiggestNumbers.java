package com.ebiggerr;

import java.util.Arrays;

public class printTwoBiggestNumbers {

    public static void main(String[] args)
    {
        int num[] = {5,34,78,2,45,1,98,23,97,98,-45};
        printTwoBiggestNumbers(num);

    }

    public static void printTwoBiggestNumbers(int[] n)
    {

        Arrays.sort(n);
        int last = n.length-1;
        int secondLast = last -1;

        for( int index = 0; index < n.length ; index ++){

            //if secondlast is equal to last then check the previous until found the second largest
            if( n[secondLast] == n[last]) secondLast--;

        }

        System.out.println( "Greatest Number: " + n[secondLast] );
        System.out.println( "Second Greatest Number: " + n[last] );


    }

}
