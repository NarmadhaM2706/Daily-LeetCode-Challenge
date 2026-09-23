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
    int tot=0;
    public int sumRootToLeaf(TreeNode root) {
        if(root == null)return 0;
        solve(root,0);
        return tot;
    }
    public void solve(TreeNode root,int sum)
    {
        if(root == null)return;
        sum=sum*2+root.val;
        if(root.left == null && root.right == null)
        {
            tot+=sum;
            return;
        }
        solve(root.left,sum);
        solve(root.right,sum);
    }
}