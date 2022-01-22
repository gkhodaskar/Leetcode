// Problem Description: https://leetcode.com/problems/water-bottles/

class WaterBottles {

    // O(logn), where n = numBottles
    public int numWaterBottles(int numBottles,int numExchange){
        // numBottles: water bottles that are initially full of water
        // numExchange: number of empty water bottles that can be
        // exchanged for one full water bottle
        if(numExchange==0)return numBottles;

        int result=numBottles;
        int emptyBottles=0;


        while(numBottles>=numExchange){
            emptyBottles=numBottles%numExchange; // Bottles that can't be exchanged right now
            numBottles /= numExchange; // new full water bottles after exchange
            result+=numBottles; // add to result as these can be consumed
            numBottles+=emptyBottles; // update total number of empty bottles available
        }

        return result;
    }
}