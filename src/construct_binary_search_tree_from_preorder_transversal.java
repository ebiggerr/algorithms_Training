public class construct_binary_search_tree_from_preorder_transversal {

    /*
    *   Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)



Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
*
*   Representation of binary search tree(the output from the example above)
*
*                    8
*           5               10
*        1     7     (null)       12
*
*       The null is not an actual node, just to express there is nothing on the left side of (10) node,having on a right child node.
    * */


    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

        int i = 0;

        public TreeNode bstFromPreorder(int[] preorder) {
            return bstFromPreorder(preorder, Integer.MAX_VALUE);
        }

        public TreeNode bstFromPreorder(int[] A, int bound) {
            if (i == A.length || A[i] > bound)
                return null;
            TreeNode root = new TreeNode(A[i++]);
            root.left = bstFromPreorder(A, root.val);
            root.right = bstFromPreorder(A, bound);
            return root;
        }



    public static void main(String [] args){

            //have to construct a preorder transversal
            //using the TreeNode

    }

    /*

    Explanation of the solution
    *
    * Give the function a bound the maximum number it will handle.
The left recursion will take the elements smaller than node.val
The right recursion will take the remaining elements smaller than bound

Complexity
bstFromPreorder is called exactly N times.
It's same as a preorder traversal.
Time: O(N)*/
}
