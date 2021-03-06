import java.util.List;

public class Leftmost_Column_with_at_Least_a_One {

    /*
    * (This problem is an interactive problem.)

A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.

You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:

BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.

For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.



    Example 1:
*
*   0 0
*   1 1
*
*   Input: mat = [[0,0],[1,1]]
    Output:
    *
    *
    *Input: mat = [[0,0],[0,1]]
    Output: 1
    Example 3:



    Input: mat = [[0,0],[0,0]]
    Output: -1
    Example 4:



    Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
    Output: 1
    * */


    /**
     * // This is the BinaryMatrix's API interface.
     * // You should not implement it, or speculate about its implementation
     interface BinaryMatrix {
         public int get(int x, int y) {}
        public List<Integer> dimensions {}
     * };
     */
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension=binaryMatrix.dimensions();

        int row=dimension.get(0);
        int col=dimension.get(1);

        if(row==0 || col == 0){
            return -1;
        }

        int result =-1;

        int r=0;
        int c=col-1;

        while( r<row && c>=0 ){
            if(binaryMatrix.get(r,c)==1){
                result=c;
                c--;
            }
            else{
                r++;
            }
        }
        return result;
    }
}
