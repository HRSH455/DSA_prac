class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer,Integer> hm = new HashMap<>();
        int currSum =0,res=0;
        hm.put(0,1);
        for(int num : nums){
            currSum +=num % 2;
            res += hm.getOrDefault(currSum-k,0);
            hm.put(currSum,hm.getOrDefault(currSum,0)+1);
        }
        return res;
        
    }
}