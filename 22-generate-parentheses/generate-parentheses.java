class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        fun("",0,0,n);
        return ans;
    }
public void fun(String s,int oc,int cc,int n)
{
    if(s.length() == 2*n)
    {
        ans.add(s);
        return;
    }
    if(oc<n)
    {
        fun(s+"(",oc+1,cc,n);
    }
    if(cc<oc)
    {
        fun(s+")",oc,cc+1,n);
    }
}
    
    }
