class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> hm = new HashMap<>();
        int currSum=0,res = 0;
        hm.put(0,1);
        for(int num : nums){
            currSum +=num;
            res +=hm.getOrDefault(currSum-goal,0);
            hm.put(currSum,hm.getOrDefault(currSum,0)+1);
        }
        return res;
        
    }
}