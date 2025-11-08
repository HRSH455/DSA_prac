class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen =Integer.MAX_VALUE;
        int n=nums.length;
        int left=0;
        int curSum =0;
        for(int r=0;r<n;r++){
            curSum +=nums[r];
            while(curSum >= target){
                if(r-left+1 < minLen){
                    minLen= r-left+1;
                }
                curSum -=nums[left];
                left++;
            }
            
        }
        if(minLen == Integer.MAX_VALUE) return 0;
        return minLen;

    }
}