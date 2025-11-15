class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int c =0, sum =0;
        Map<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int num : nums){
            sum +=num;
            if(hm.containsKey(sum-k)){
                c+=hm.get(sum-k);
            }
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        
        return c;
    }
}