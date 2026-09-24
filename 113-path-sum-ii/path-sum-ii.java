import java.util.*;

class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        check(root, targetSum, path, result);

        return result;
    }

    public void check(TreeNode root, int targetSum,
                      List<Integer> path,
                      List<List<Integer>> result) {

        if (root == null) {
            return;
        }

        path.add(root.val);

        if (root.left == null && root.right == null) {

            if (root.val == targetSum) {
                result.add(new ArrayList<>(path));
            }

            path.remove(path.size() - 1);

            return;
        }

        targetSum = targetSum - root.val;

        check(root.left, targetSum, path, result);

        check(root.right, targetSum, path, result);

        path.remove(path.size() - 1);
    }
}