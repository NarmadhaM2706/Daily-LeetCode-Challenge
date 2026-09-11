class Solution {
    public int findMaxFish(int[][] grid) {
      int m=grid.length;
      int n= grid[0].length;
      int sum=0;
      for(int i=0;i<m;i++)
      {
        for(int j=0;j<n;j++)
        {
            if(grid[i][j]> 0)
            {
                int fish=dfs(grid,i,j);
                sum=Math.max(sum,fish);
            }
        }
      }
return sum;
    }
    public int dfs(int[][] grid,int i,int j)
    {
if(i<0 || j<0 ||i==grid.length || j==grid[0].length || grid[i][j] == 0)
{
    return 0;
}
int fish=grid[i][j];
grid[i][j]=0;
fish += dfs(grid,i,j-1);
fish += dfs(grid,i,j+1);
fish += dfs(grid,i-1,j);
fish += dfs(grid,i+1,j);
return fish;
    }
}