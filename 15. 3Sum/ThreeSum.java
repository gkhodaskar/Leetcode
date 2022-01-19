// Problem Description: https://leetcode.com/problems/3sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    // O (nlogn + n^2) ~ O(n^2)
    public List<List<Integer>>threeSum(int[]nums){
        List<List<Integer>>result=new ArrayList<>();
        Arrays.sort(nums); // O(nlogn)

        for(int i=0;i<nums.length;i++){ // O(n^2)

            if(i==0||nums[i-1]!=nums[i]){
                twoSum(nums,i,result);
            }
        }

        return result;
    }

    // twoSum() : O(n)
    private void twoSum(int[]nums,int i,List<List<Integer>>result){

        int lo=i+1;
        int hi=nums.length-1;
        while(lo<hi){
            int sum=nums[i]+nums[lo]+nums[hi];

            if(sum< 0){
                ++lo;
            }else if(sum>0){
                --hi;
            }else{
                result.add(Arrays.asList(nums[i],nums[lo++],nums[hi--]));
                while(lo<hi &&nums[lo]==nums[lo-1])
                    ++lo;

            }
        }
    }
//     public List<List<Integer>> threeSum(int[] nums) {
//         Set<List<Integer>> result = new HashSet<>();
//         Set<Integer> duplicates = new HashSet<>();
//         Map<Integer, Integer> seen = new HashMap<>();

//         for (int i = 0; i < nums.length; ++i)

//             if (duplicates.add(nums[i])) {
//                 for (int j = i + 1; j < nums.length; ++j) {
//                     int complement = - nums[i] - nums[j];
//                     if (seen.containsKey(complement) && seen.get(complement) == i) {
//                         List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
//                         Collections.sort(triplet);
//                         result.add(triplet);
//                     }
//                     seen.put(nums[j], i);
//                 }
//             }

//         return new ArrayList(result);
//     }
}