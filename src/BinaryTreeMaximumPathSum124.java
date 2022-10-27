import addons.TreeBuilder;
import addons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/">
 * 124. Binary Tree Maximum Path Sum</a>
 */

public class BinaryTreeMaximumPathSum124 {

    public static void main(String[] args) {
        //Integer[] root = {1, 2, 3};
        Integer[] root = {-10, 9, 20, null, null, 15, 7};

        TreeNode rootNode = TreeBuilder.build(root);

        System.out.print(maxPathSum(rootNode));
    }

    private static int maxPathSum(TreeNode root) {

        List<Integer> maxSumList = new ArrayList<>();

        maxSumList.add(root.val);

        dfs(root, maxSumList);

        return maxSumList.get(0);
    }

    private static int dfs(TreeNode node, List<Integer> maxSumList) {

        if (node == null) {
            return 0;
        }

        int leftSum = Math.max(0, dfs(node.left, maxSumList));
        int rightSum = Math.max(0, dfs(node.right, maxSumList));

        maxSumList.set(0, Math.max(leftSum + rightSum + node.val, maxSumList.get(0)));

        return node.val + Math.max(leftSum, rightSum);

    }
}
