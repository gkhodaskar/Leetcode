// Problem Description: https://leetcode.com/problems/two-sum

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        // n : size of input array nums
        // TC: O(n^2), SC: O(1)
        // for(int i = 0; i < nums.length-1; i++){ // O(n)
        //     for(int j = i+1; j<nums.length; j++){ // O(n)
        //         if(nums[i] + nums[j] == target){
        //             return new int[]{i, j};
        //         }
        //     }
        // }

        // TC: O(n), SC: O(n)
        Map<Integer, Integer> values = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (values.containsKey(target - nums[i])) {
                return new int[]{values.get(target - nums[i]), i};
            } else {
                values.put(nums[i], i);
            }
        }

        return null;
    }
}