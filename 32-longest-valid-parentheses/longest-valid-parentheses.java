class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st= new Stack<>();
        char[] ch=s.toCharArray();
        int max=0;
        int d=0;
        st.push(-1);
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='(')
            {
                st.push(i);
            }
            else
            {
                st.pop();
                if(!st.isEmpty())
                {
                    d=i-st.peek();
                    max=Math.max(d,max);
                }
                else
                {
                    st.push(i);
                }
            }
        }
return max;
    }
}