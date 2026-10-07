class Solution {
    public int empty=0, ans=0;
    public void dfs(int[][] mat,int i,int j,int count){
        if(i<0 || i==mat.length || j<0 || j==mat[0].length)
            return;
        if(mat[i][j]==-1)
            return;
        if(mat[i][j]==2){
            if(count==empty)
                ans++;
            return;
        }
        if(mat[i][j]==0) count++;
        mat[i][j]=-1;
        dfs(mat,i-1,j,count);
        dfs(mat,i+1,j,count);
        dfs(mat,i,j-1,count);
        dfs(mat,i,j+1,count);
        mat[i][j]=0;
    }
    public int uniquePathsIII(int[][] grid) {
        int flagR=0, flagC=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0)
                    empty++;
                if(grid[i][j]==1){
                    flagR=i; flagC=j;
                }
            }
        }
        dfs(grid,flagR,flagC,0);
        return ans;
    }
}