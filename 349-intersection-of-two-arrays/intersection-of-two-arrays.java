class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2= new HashSet<>();
        for(int n:nums1)
        {
            set1.add(n);
        }
        for(int num:nums2)
        {
            if(set1.contains(num))
            {
                set2.add(num);
            }
        }
        int[] res=new int[set2.size()];
        int ind=0;
        for(int i:set2){
            res[ind++]=i;
        }
    return res;
    }
}