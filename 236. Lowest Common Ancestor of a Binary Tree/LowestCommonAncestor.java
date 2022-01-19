// Problem Description: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

class LowestCommonAncestor{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Root is invalid or is leaf node || p or q was found
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p , q); // check left subtree
        TreeNode right = lowestCommonAncestor(root.right, p , q); // check right subtree

        if(left != null && right != null) return root;

        return left != null ? left : right;
    }
}