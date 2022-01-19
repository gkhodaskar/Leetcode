// Problem Description: https://leetcode.com/problems/binary-search/

class BinarySearch {

    public int search(int[]nums,int target){
        int start=0,end=nums.length;

        if(nums==null||nums.length==0||target>nums[end-1])return-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]<target) // go to right half
                start=mid+1;
            else // go to left half
                end=mid-1;
        }

        return-1;

    }
}