class Solution {
    public int findCircleNum(int[][] grid) {
        int m=grid.length;
        int  pro=0;
        for(int i=0;i<m;i++){
                if(grid[i][i] == 1){
                pro++;
                dfs(grid,i);
                }
        }
        return pro;
    }
    public void dfs(int[][] grid,int  i)
    {
       for(int j=0;j<grid.length;j++)
       { 
        if(grid[i][j] == 1)
         {
        grid[i][j] = 0;
        dfs(grid,j);
        }
       }
    }
}