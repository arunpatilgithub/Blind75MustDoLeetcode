import addons.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/validate-binary-search-tree/">98. Validate Binary Search Tree</a>
 */
public class ValidateBinarySearchTree98 {

    public static void main(String[] args) {

        Integer[] root = {2, 1, 3};
        //Integer[] root = {5, 1, 4, null, null, 3, 6};
        //Integer[] root = {5, 4, 6, null, null, 3, 7};
        //Integer[] root = {2147483647};

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode rootNode = new TreeNode(root[0]);

        int i = 0;
        queue.add(rootNode);
        while (i < root.length - 1) {
            TreeNode existingNode = queue.remove();

            Integer left = root[++i];
            Integer right = root[++i];


            if (left != null) {
                TreeNode leftNode = new TreeNode(left);
                queue.add(leftNode);
                existingNode.left = leftNode;
            } else {
                existingNode.left = null;
            }

            if (right != null) {
                TreeNode rightNode = new TreeNode(right);
                queue.add(rightNode);
                existingNode.right = rightNode;
            } else {
                existingNode.right = null;
            }

        }

        System.out.println(isValidBST(rootNode));

    }

    private static boolean dfs(TreeNode node, Integer left, Integer right) {

        if (node == null) {
            return true;
        }

        if ((left != null && node.val <= left) || (right != null && node.val >= right)) {
            return false;
        }

        return dfs(node.left, left, node.val) && dfs(node.right, node.val, right);
    }

    public static boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }


}
