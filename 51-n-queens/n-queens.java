class Solution {
    public List<List<String>> result=  new ArrayList<>();
    public List<String> list= new ArrayList<>();
    public int count=0;
    public boolean check(int r,int c,int n)
    {
        for(int i=r-1;i>=0;i--)
        {
            if(list.get(i).charAt(c)=='Q')
               return false;
        }
        for(int i=r-1,j=c-1;i>=0 && j>=0;i--,j--)
        {
                if(list.get(i).charAt(j) =='Q')
                return false;
        }
        for(int i=r-1,j=c+1;i>=0 && j<n;i--,j++)
        {  
                if(list.get(i).charAt(j) == 'Q')
                 return false;
        }
        return true;
    }
    public void fun(int r,int n)
    {
            for(int i=0;i<n;i++)
            {
                if(check(r,i,n))
                {
                String curr=list.get(r);
                StringBuilder sb= new StringBuilder();
                for(int k=0;k<n;k++)
                {
                    if(k==i) sb.append("Q");
                    else
                     sb.append(".");
                }
                list.set(r,sb.toString());
                count++;
                if(count==n)
                {
                    result.add(new ArrayList<>(list));
                }
                fun(r+1,n);
                list.set(r,curr);
                count--;
                }
            }
    }
    public List<List<String>> solveNQueens(int n) {
     for(int i=0;i<n;i++)
     {
        list.add("....");
     }   
    fun(0,n);
    return result;
    }
}