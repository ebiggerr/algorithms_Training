

public class Check_If_a_String_Is_a_Valid_Sequence_from_Root_to_Leaves_Path_in_a_Binary_Tree {



    /*
    *       Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree.

            We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.
            *
            *
            * Example 1

                         0
                      /     \
                  1            0
                /   \         /
    *         0      1       0
    *          \    /  \
    *           1   0   0
    *
    *
    *       Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
            Output: true
            *
            *           (0)
                      /     \
                 (1)            0
                /   \         /
             (0)      1       0
               \    /  \
              (1)   0   0
            *
            *
            *
            Explanation:
            The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure).
            Other valid sequences are:
            0 -> 1 -> 1 -> 0
            0 -> 0 -> 0
    * */

    //Definition for a binary tree node
    private class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){

        }
        TreeNode (int val){
            this.val=val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }

    public boolean isValidSequence(TreeNode root, int[] arr) {

        if(root == null ){
            return arr.length == 0;
        }
        return checkValidSequence( root,arr,0);


    }

    private boolean checkValidSequence(TreeNode root, int[]arr, int index){

        if(root.val != arr[index]){
            return false;
        }
        if(index == arr.length-1){
            return root.left == null && root.right == null;
        }

        return ( (root.left != null && checkValidSequence(root.left , arr ,index+1)) || //or
                root.right != null && checkValidSequence(root.right , arr ,index+1));
    }

    public static void main(String [] args){

        Check_If_a_String_Is_a_Valid_Sequence_from_Root_to_Leaves_Path_in_a_Binary_Tree c=new Check_If_a_String_Is_a_Valid_Sequence_from_Root_to_Leaves_Path_in_a_Binary_Tree();







    }


}
