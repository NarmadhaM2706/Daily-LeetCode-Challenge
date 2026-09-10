class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=1;
        int c=1;
        int max =1;
        if(nums.length==0)
        {
            return 0;
        }
        while(j<nums.length )
        {
            if(nums[i] == nums[j])
            {
                i++;
                j++;
            }
            else if(nums[j]-nums[i]== 1)
            {
                c++;
                max=Math.max(max,c);
                i++;
                j++;
            }
            else
            {
                c=1;
                i++;
                j++;
            }
        }
        return max;
    }
}