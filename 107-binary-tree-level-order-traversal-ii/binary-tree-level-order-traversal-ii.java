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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        if(root == null)
        {
            return result;
        }
        while(!q.isEmpty())
        {
            int s=q.size();
            List<Integer> list= new ArrayList<>();
            for(int i=0;i<s;i++)
            {
                TreeNode p=q.poll();
                list.add(p.val);
                if(p.left != null)
                {
                   q.add(p.left);
                }
                if(p.right != null)
                {
                    q.add(p.right);
                }
            }
            result.add(list);
        }
        Collections.reverse(result);
        return result;
    }
}