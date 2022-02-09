// Problem Description: https://leetcode.com/problems/find-leaves-of-binary-tree/
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
class FindLeavesOfBinaryTree{
    List<List<Integer>> result;

    // The height of a node is the number of edges from the node to the deepest leaf. We
    // calculate this by using post order traversal.
    // The nodes with same height will be eliminated together. Leaves will have height 0.
    public List<List<Integer>> findLeaves(TreeNode root) {
        // O(N) space
        result = new ArrayList<List<Integer>>();

        // O(N)
        dfs(root);

        return result;
    }

    private int dfs(TreeNode root){
        if(root == null)
            return -1;

        // Get maximum height of left and right children to calculate height of this node
        int height = 1 + Math.max(dfs(root.left), dfs(root.right));

        // This happens in the order height = 0, 1, 2, ... starting from the innermost recursive call
        // i.e. when leaf node is reached.
        // If the result is empty and height is zero(leaves), we need to add a new list to add the leaf
        // nodes and so on.
        if(result.size() < height+1)
            result.add(new ArrayList<>());

        // Add the value of this node to sublist corresponding to height index
        result.get(height).add(root.val);
        return height;
    }
}