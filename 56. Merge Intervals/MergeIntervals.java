//Problem Description: https://leetcode.com/problems/merge-intervals/

class MergeIntervals {
    public int[][]merge(int[][]intervals){
        // Sort intervals based on start time
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        LinkedList<int[]>merged=new LinkedList<>();

        for(int[]interval:intervals){
            if(merged.isEmpty()||interval[0]>merged.getLast()[1]){
                merged.add(interval);
            }
            else{
                merged.getLast()[1]=Math.max(merged.getLast()[1],interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}