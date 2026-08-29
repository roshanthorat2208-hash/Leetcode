/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
     if(root == null){
        return 0;
     } 

     int left = getDepth(root.left);
     int right = getDepth(root.right);  
     if(left == right){
        return(1<<left)+countNodes(root.right);

     }
     return (1<<right)+countNodes(root.left);
    }

    private int getDepth(TreeNode root){
        int depth=0;
        while(root !=null){
            depth++;
            root = root.left;
        }
        return depth ;
    }
}