class SumZero {
    // Add positive and negative of the same number <= n/2
    // O(n)
//     public int[] sumZero(int n) {
//         int[] result = new int[n];

//         // Only process if n >= 2
//         for(int i = 1; i <= n/2; i++){
//             result[i-1] = i; // add positive num
//             result[n-i] = -i; // corresponding negative num
//         }

//         return result;
//     }

    // Similar to above code but more intuitive
    // O(n)
    public int[] sumZero(int n) {
        if(n == 0) // No elements
            return new int[0];

        if(n == 1) // Single element, must be a zero
            return new int[]{0};

        int[] result = new int[n];
        int mid = n/2;

        // Add positive and negative number for each mid value
        for(int start = 0, end = n-1; start < end; start++, end--){
            result[start] = -(mid);
            result[end] = mid;
            mid--;
        }

        return result;
    }
}