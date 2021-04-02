public class minumum_path_sum {

    /*
    * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.

    Example:

    Input:
    [
    [1,3,1],
    [1,5,1],
    [4,2,1]
    ]
    Output: 7

    * Explanation: Because the path 1→3→1→1→1 minimizes the sum.


    * */


    public int minimumPathSum(int [][]grid){

        int[][] memo = new int[grid.length][grid[0].length];
        return minPathSumHelper(grid, 0, 0, memo);
    }

    public int minPathSumHelper(int[][] grid, int row, int col, int[][] memo) {
        if(row == grid.length-1 && col == grid[0].length-1) return grid[row][col];
        if(memo[row][col] != 0) return memo[row][col];

        int rowInc = Integer.MAX_VALUE, colInc = Integer.MAX_VALUE;
        if(row < grid.length-1) rowInc = minPathSumHelper(grid, row+1, col, memo);
        if(col < grid[0].length-1) colInc = minPathSumHelper(grid, row, col+1, memo);
        memo[row][col] = Math.min(rowInc, colInc) + grid[row][col];
        return memo[row][col];
    }

    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        // Initial memo to store already computed back tracking
        // path value on each corresponding position =>
        // Each cell in memo mapping to cell in given grid and
        // store the minimum path sum calculated backwards from
        // bottom right corner cell to this cell
        int[][] memo = new int[m][n];
        return helper(grid, 0, 0, memo);
    }

    private int helper(int[][] grid, int i, int j, int[][] memo) {
        if(i < grid.length && j < grid[0].length) {
            if(i == grid.length - 1 && j == grid[0].length - 1) {
                // Store current cell value in memo if we reach
                // to bottom right and return it
                memo[i][j] = grid[i][j];
                return memo[i][j];
            }
            // Consult memo in case we have already calculated routes
            // for a particular cell, if the result not as initial as
            // 0, return it, otherwise use the usual recursion on
            // bottom and right direction
            if(memo[i][j] != 0) {
                return memo[i][j];
            }
            int bottom = helper(grid, i + 1, j, memo);
            int right = helper(grid, i, j + 1, memo);
            // Take the minimum value for a cell on a decision tree
            int min = Math.min(bottom, right);
            // Add cell value to the minimum value from left or right child
            memo[i][j] = min + grid[i][j];
            return memo[i][j];
        }
        return Integer.MAX_VALUE;
    }


    public static void main(String [] args){

        int [][]map={{1,2,3,4,5},
                     {1,1,1,2,1},
                     {3,4,5,6,1},
                     {6,9,8,1,2},
                     {1,3,5,6,1}};

        minumum_path_sum m=new minumum_path_sum();

        System.out.println(m.minimumPathSum(map));

        //method with explanation
        System.out.println(m.minPathSum(map));
    }
}
