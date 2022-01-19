// Problem Description: https://leetcode.com/problems/container-with-most-water

public class MaxArea {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0; // Maximum area

        // Two Pointer, Single pass
        // TC: O(n), SC: O(1)

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area); // Update max

            // Move the pointer with shorter line
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return max;
    }
}