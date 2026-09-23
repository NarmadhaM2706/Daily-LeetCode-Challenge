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
    int tilt=0;
    public int findTilt(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        Sum(root);
        return tilt;
    }
    public int Sum(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int leftSum=Sum(root.left);
        int RightSum=Sum(root.right);
        tilt+=Math.abs(leftSum-RightSum);
        return leftSum+RightSum+root.val;
    }
}