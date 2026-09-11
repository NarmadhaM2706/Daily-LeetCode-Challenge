class Solution {
    public void dfs(int[][] grid,int sr,int sc,int color,int original)
    {
        if(sc<0 || sr<0 || sr== grid.length|| sc == grid[0].length || grid[sr][sc] != original)
        {
            return;
        }
        grid[sr][sc]=color;
        dfs(grid,sr,sc-1,color,original);
        dfs(grid,sr,sc+1,color,original);
        dfs(grid,sr-1,sc,color,original);
        dfs(grid,sr+1,sc,color,original);
    }
    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        int m=grid.length;
        int n=grid[0].length;
        int original = grid[sr][sc];
        if(original == color){
            return grid;
        }
        dfs(grid,sr,sc,color,original);
        return grid;
    }
}