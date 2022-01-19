// Problem Description: https://leetcode.com/problems/trapping-rain-water/

class TrapRainWater {
    public int trap(int[]height){
        int left=0,right=height.length-1;
        int leftMax=0,rightMax=0;
        int totalVol=0; // total volume
        while(left<right){
            // Left bar is smaller than right bar
            if(height[left]<height[right]){
                // if taller than leftMax, update leftMax
                if(leftMax<height[left])
                    leftMax=height[left];
                else // otherwise, add to total volume
                    totalVol+=leftMax-height[left];

                // Move right
                left++;
            }else{ // right bar is smaller or equal to left
                // if this bar is taller than last right highest, update rightMax
                if(rightMax<height[right])
                    rightMax=height[right];
                else // add to total volume
                    totalVol+=rightMax-height[right];

                // Move left
                right--;
            }
        }
        return totalVol;
    }
}