class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmostd(nums,k)-atmostd(nums,k-1);
        
    }
    public int atmostd(int[] nums, int k){
        int i=0,j=0,n=nums.length,c=0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        while(j < n){
            hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
            while(hm.size() > k){
                hm.put(nums[i],hm.get(nums[i])-1);

                if(hm.get(nums[i])==0){
                    hm.remove(nums[i]);
                }
                i++;
            }
            c += (j-i+1);
            j++;
        }
        return c;
    }
}