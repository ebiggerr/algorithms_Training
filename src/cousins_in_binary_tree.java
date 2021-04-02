
import java.util.ArrayDeque;
import java.util.Deque;

public class cousins_in_binary_tree {

    /*
    *       In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

            Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

            We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

            Return true if and only if the nodes corresponding to the values x and y are cousins.

                     1
                  /      \
                2         3
               /
               4
              Input: root = [1,2,3,4], x = 4, y = 3
              Output: false

                      1
                  /      \
                2         3
                 \          \
                  4           5
              Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
              Output: true




    *
    * */


      //Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
        }
      }


        public boolean isCousins(TreeNode root, int x, int y) {
            assert (x != y);    // all values in the tree are unique

            Deque<TreeNode[]> queue = new ArrayDeque<>();
            queue.addLast(new TreeNode[]{root, null});

            boolean xFound = false;
            boolean yFound = false;
            TreeNode xParent = null;
            TreeNode yParent = null;

            while (queue.size() > 0) {

                int currLevelSize = queue.size();
                for (int i = 0; i < currLevelSize; ++i) {

                    TreeNode[] pair = queue.removeFirst();
                    TreeNode currNode = pair[0];
                    TreeNode parent = pair[1];

                    if (currNode.val == x) {
                        xFound = true;
                        xParent = parent;

                    } else if (currNode.val == y) {
                        yFound = true;
                        yParent = parent;
                    }

                    if (currNode.left != null) queue.addLast(new TreeNode[]{currNode.left, currNode});
                    if (currNode.right != null) queue.addLast(new TreeNode[]{currNode.right, currNode});

                }

                if (xFound && yFound) {
                    return xParent != yParent;  // same level AND different parents

                } else if (xFound || yFound) {
                    return false;               // found one but not the other, they can't be at the same level
                }

                assert (!xFound && !yFound);    // neither of the two values has been found in the current level
            }


            assert (false);     // neither x nor y is in the tree
            return false;
        }




}
