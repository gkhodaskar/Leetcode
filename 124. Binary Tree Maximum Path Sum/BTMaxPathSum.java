// Problem description: https://leetcode.com/problems/binary-tree-maximum-path-sum/

class BTMaxPathSum{

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    // Depth First Search
    public int helper(TreeNode current){
        if(current == null) return 0;

        int left = Math.max(helper(current.left), 0); // Max path in left subtree
        int right = Math.max(helper(current.right), 0); // Max path in right subtree

        max = Math.max(max, current.val+left+right); // update max

        return current.val+Math.max(left,right); // return maximum path in this subtree
    }
}