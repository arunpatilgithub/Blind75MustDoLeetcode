package addons;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBuilder {

    public static TreeNode build(Integer[] root) {

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode rootNode = new TreeNode(root[0]);

        int i = 0;
        queue.add(rootNode);
        while (i < root.length - 1) {
            TreeNode existingNode = queue.remove();

            Integer left = root[++i];
            Integer right = null;
            
            if (i < root.length - 1) {
                right = root[++i];
            }


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
        return rootNode;

    }

}
