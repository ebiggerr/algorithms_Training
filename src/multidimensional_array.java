
public class multidimensional_array {

    public static void main(String []args) {

        int[][] matrix = new int[4][4];

        int row;
        int column;
        int sum=0;
        int sumofColumn=0;
        int[][] temp;

        int [][]array={
                {1,2,3},  //row
                {4,5,6},
                {7,8,9},
                {10,11,12}};

        /*
        for(row=0;row<matrix.length;row++){
            for(column=0;column<matrix[row].length;column++){
                matrix[row][column]=(int)(Math.random()*1000);
            }
        }
        */
        for(int row1=0;row1<array.length;row1++){
            for(int column1=0;column1<array[row1].length;column1++){
                System.out.print(array[row1][column1]+"\t");

                sum+=array[row1][column1];

                sumofColumn+=array[row1][column1];


            }


            System.out.print("-->  " + (row1+1) +"th row");

            System.out.print("  The sum of all elements in this row is " +sumofColumn);
            System.out.println();

            //reset the sum after get the sum of a row
            sumofColumn=0;
        }
        System.out.println("The sum of all elements in the 4x4 array is "+sum);


    }


}
