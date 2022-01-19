// Problem Description: https://leetcode.com/problems/rotting-oranges/

class RottingOranges{

    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;

        //Add the position of all rotten oranges to queue
        //count the number of fresh oranges
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i , j});
                }
                else if(grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }
        //if count of fresh oranges is zero --> return 0
        if(count_fresh == 0) return 0;

        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // Breadth First Search: Start from initially rotten oranges
        while(!queue.isEmpty()) {
            if(count_fresh == 0) return count; // All fresh oranges have rotten

            ++count;
            int size = queue.size();

            for(int i = 0 ; i < size ; i++) {
                int[] point = queue.poll();
                for(int dir[] : dirs) {

                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];

                    // if x or y is out of bound
                    // OR the orange at (x , y) is already rotten
                    // OR the cell at (x , y) is empty
                    // Do nothing/Skip this position in grid
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue;

                    // otherwise, 1. mark the orange at (x , y) as rotten
                    grid[x][y] = 2;
                    // 2. put the new rotten orange at (x , y) in queue
                    queue.offer(new int[]{x , y});
                    // 3. decrease the count of fresh oranges by 1
                    count_fresh--;
                }
            }
        }

        return -1;
    }
}