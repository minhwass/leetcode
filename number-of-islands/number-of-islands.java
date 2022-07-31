class Solution {
    public int numIslands(char[][] grid) {
        int nums = 0; 
        for(int r = 0 ;  r< grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == '1'){
                    numIslands(grid, r, c);
                    nums++;
                }
            }
        }
        return nums;
    }
    
    public void numIslands(char[][] grid, int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return;
        if(grid[row][col] != '1') return ; 
        grid[row][col] = '0';
       //check top
        numIslands(grid,row-1, col);
        //check bottom
        numIslands(grid, row+1, col);
        //check left
        numIslands(grid, row, col-1);
        //check right
        numIslands(grid, row, col+1);
    }
}