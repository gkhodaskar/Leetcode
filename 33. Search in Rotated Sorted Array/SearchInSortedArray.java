// PD: https://leetcode.com/problems/search-in-rotated-sorted-array/

class SearchInSortedArray{
    // Binary Search
    // O(logN), O(1)
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[start] <= nums[mid]) { // left half sorted
                // if nums[left] <= target < mid
                if (nums[start] <= target && target < nums[mid])
                    end = mid - 1; // check left half
                else start = mid + 1; // check right half
            }
            else { // right half sorted
                // if nums[mid] < target <= nums[end], check right half
                if (nums[mid] < target && target <= nums[end])
                    start = mid + 1;
                else end = mid - 1; // check left half
            }
        }

        return -1;
    }
}