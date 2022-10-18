import addons.TreeBuilder;
import addons.TreeNode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">LC102. Binary Tree Level Order Traversal</a>
 */

public class BinaryTreeLevelOrderTraversal102 {

    public static void main(String[] args) {

        Integer[] root = {3,9,20,null,null,15,7};
        //Integer[] root = {};
        TreeNode rootNode = TreeBuilder.build(root);
        List<List<Integer>> levelOrder = levelOrder(rootNode);
        List<List<Integer>> levelOrder2 = levelOrder2(rootNode);
        System.out.println(levelOrder);
    }

    public static List<List<Integer>> levelOrder2(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> output = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty() && queue.peek() != null) {

            int level = queue.size();
            List<Integer> levelList = new ArrayList<>();

            for (int i=0; i<level; i++) {
                TreeNode tempNode = queue.poll();
                levelList.add(tempNode.val);

                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }

                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }

            output.add(levelList);

        }

        return output;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> output = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        bfs(output, queue);
        return output;
    }

    private static void bfs(List<List<Integer>> output, Queue<TreeNode> queue) {

        if (queue.isEmpty()) {
            return;
        }

        Queue<TreeNode> tempQueue = new LinkedList<>();
        List<Integer> tempOutput = new ArrayList<>();

        while (!queue.isEmpty() && queue.peek() != null) {
            TreeNode tempNode = queue.poll();
            tempOutput.add(tempNode.val);

            if (tempNode.left != null) {
                tempQueue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                tempQueue.add(tempNode.right);
            }

        }
        output.add(tempOutput);
        bfs(output, tempQueue);

    }


}
