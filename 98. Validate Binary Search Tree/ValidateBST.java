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
class ValidateBST {

    private Integer prev;

    // Method II. Inorder traversal
    // TC: O(n) -> Must visit each node
    // SC: O(n) -> Recursion stack
    public boolean isValidBST(TreeNode root) {

        prev = null;
        return inorder(root);

    }
    private boolean inorder(TreeNode root){
        if(root == null) return true;

        // Left subtree -> Keep going left to the leftmost leaf
        if(!inorder(root.left)) return false;

        // Check if this node's value is smaller than previously seen value -> return false
        if(prev!=null && root.val <= prev)
            return false;

        // Update prev
        prev = root.val;
        // Right subtree
        return inorder(root.right);
    }

    // Method I. Plain old recursive Divide and Conquer on left and right subtree
    // TC: O(n) -> Must visit each node
    // SC: O(n) -> Recursion stack
//     public boolean isValidBST(TreeNode root) {
//         return isValidBST(root, null, null);
//     }

//     private boolean isValidBST(TreeNode node, Integer min, Integer max){
//         if (node == null) return true;

//         if((min != null && node.val <= min) || (max!= null && node.val >= max))
//             return false;

//         return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
//     }
}