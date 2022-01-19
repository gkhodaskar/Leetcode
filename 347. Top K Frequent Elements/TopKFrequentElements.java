// Problem Description: https://leetcode.com/problems/top-k-frequent-elements/

import java.util.*;

class TopKFrequentElements{
    public int[] topKFrequent(int[] nums, int k) {

        if(k == nums.length)
            return nums;

        Map<Integer, Integer> numFrequency = new HashMap<>();
        for(int n : nums){
            numFrequency.put(n, numFrequency.getOrDefault(n,0)+1);
        }

        // Create heap sorted based on integer added to heap
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)-> Integer.compare(numFrequency.get(a), numFrequency.get(b)));

        // Add elements to the heap
        for(int n : numFrequency.keySet()){
            heap.add(n);
            if(heap.size() > k)
                heap.poll();
        }

        int[] kFrequent = new int[k];
        for(int i = k-1; i>=0; i--){
            kFrequent[i] = heap.poll();
        }
        return kFrequent;
    }
}