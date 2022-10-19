import addons.TreeBuilder;
import addons.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">LC104. Maximum Depth of Binary Tree</a>
 */

public class MaximumDepthofBinaryTree104 {

    public static void main(String[] args) {

        Integer[] root = {3, 9, 20, null, null, 15, 7};
        //Integer[] root = {1, null, 2};

        TreeNode rootNode = TreeBuilder.build(root);

        System.out.println(maxDepth(rootNode));
        System.out.println(maxDepth2(rootNode));
    }

    private static int maxDepth2(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    private static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {

            depth++;

            int levelLoopSize = queue.size();

            for (int i = 0; i < levelLoopSize; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

        }

        return depth;
    }

}
