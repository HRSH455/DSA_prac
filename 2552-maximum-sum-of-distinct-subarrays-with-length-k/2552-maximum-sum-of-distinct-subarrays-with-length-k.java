class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0,curSum =0;
        Set<Integer> set = new HashSet<>();
        int left =0;
        for(int right=0;right<nums.length;right++){
            while(set.contains(nums[right]) || set.size() == k){  
                set.remove(nums[left]);
                curSum -=nums[left];
                left++;
            }
            set.add(nums[right]);
            curSum +=nums[right];
            if(set.size() == k){
                maxSum = Math.max(curSum,maxSum);
            }
        }
        return maxSum;
        
    }
}