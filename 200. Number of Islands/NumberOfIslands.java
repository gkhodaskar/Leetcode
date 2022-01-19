// Problem Description: https://leetcode.com/problems/number-of-islands/

class NumberOfIslands{
    public int numIslands(char[][] grid) {
        // Use DFS. Keep going to (i,j+1), (i, j-1), (i+1,j) and (i-1,j) as long as they're '1'
        // Sink each position and make all points on this island 0
        // at the end add one to the total count
        // Go to next 1 entry and continue


        if (grid == null || grid.length == 0)
            return 0;

        int numOfIslands = 0;

        // Traverse to each element in the matrix, possible individual islands spread all over
        // grid =  [
        //         ["1","0","1","0","1"],
        //         ["0","1","0","1","0"],
        //         ["1","0","1","0","1"],
        //         ["0","1","0","1","0"]
        //         ]

        // Another edge case : no islands OR a single island at (grid.length-1, grid[i].length-1)

        // I. DFS Solution O(m*n)
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                if(grid[i][j] == '1'){ // Island found
                    numOfIslands ++;
                    dfs(grid, i , j); // find all adjacent valid positions and sink them
                }
            }
        }

        return numOfIslands;
    }

    // We have found an island so we sink all linked positions to avoid counting again
    public void dfs(char[][] grid, int i , int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0'; // Sink this position in this island

        dfs(grid, i, j+1); // right
        dfs(grid, i, j-1); // left
        dfs(grid, i+1, j); // bottom
        dfs(grid, i-1, j); // top
    }
}