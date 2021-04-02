public class maximum_square {
    /*
    * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

        Example:

        Input:

        1 0 1 0 0
        1 0 1 1 1
        1 1 1 1 1
        1 0 0 1 0
        *
        * Output : 4

    *
    *
    *
    * */



    /*
    *   dp[i][j] represents the length of the square which lower right corner is located at (i, j).
        If the value of this cell is also 1, then the length of the square is the minimum of: the one above,
*       its left, and diagonal up-left value +1. Because if one side is short or missing, it will not form a square.
*
*
    *
    * */

    /**
     *
     * @param matrix map or the char grid ([][]char)
     * @return maxEdge*maxEdge : area of the square (int)
     */

    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];

        int maxEdge = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(matrix[i - 1][j - 1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),dp[i - 1][j - 1]) + 1;
                    maxEdge = Math.max(maxEdge, dp[i][j]);
                }
            }
        }

        return maxEdge * maxEdge;
    }


    public static void main(String [] args){

        maximum_square m=new maximum_square();

        char [][]grid={{'1','0','1','0','1'},
                       {'1','0','1','1','1'},
                       {'0','0','1','1','1'},
                       {'1','0','1','0','1'}};

        System.out.println(m.maximalSquare(grid));
    }
}
