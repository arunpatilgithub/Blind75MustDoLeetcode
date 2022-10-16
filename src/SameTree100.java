import addons.TreeBuilder;
import addons.TreeNode;

/**
 * <a href="https://leetcode.com/problems/same-tree/">LC100. Same Tree</a>
 */
public class SameTree100 {

    public static void main(String[] args) {

        //Integer[] p = {1, 2, 3};
        Integer[] p = {1, 2};
        //Integer[] q = {1, 2, 3};
        Integer[] q = {1, null, 2};

        TreeNode pRoot = TreeBuilder.build(p);
        TreeNode qRoot = TreeBuilder.build(q);

        System.out.println(isSameTree(pRoot, qRoot));

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

}
