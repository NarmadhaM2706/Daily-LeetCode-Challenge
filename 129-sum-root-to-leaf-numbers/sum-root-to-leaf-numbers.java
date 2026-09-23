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
    int total=0,sum=0;
    public int sumNumbers(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        solve(root);
        return total;
    }
    public void solve(TreeNode root)
    {
        if(root == null)return ;
        sum =sum*10 + root.val;
        if(root.left == null && root.right==null)
        {
            total+=sum;
            sum=0;
            return;
        }
        int temp=sum;
        solve(root.left);
        sum=temp;
        solve(root.right);
        sum=temp;
    }
}