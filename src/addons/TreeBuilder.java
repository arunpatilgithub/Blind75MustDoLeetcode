package addons;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBuilder {

    public static void main(String[] args) {

        //Integer[] root = {2, 1, 3};
        Integer[] root = {5, 1, 4, null, null, 3, 6};

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

        System.out.println(rootNode);


    }

}
