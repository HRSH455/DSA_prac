class Solution {
    public int splitArray(int[] nums, int k) {
        int mi = Integer.MIN_VALUE;
        int max = 0;
        if(nums.length<k){
            return 0;
        }
        for(int num : nums){
            mi = Math.max(mi,num);
            max += num;
        }
        int sol=0;
        while(mi <= max){
            int mid = mi+(max-mi)/2;
            if(canFit(nums,mid,k)){
                sol = mid;
                max = mid-1;
            }else{
                mi = mid+1;
            }
        }
        return sol;

        
        
    }
    public boolean canFit(int[] nums,int perk,int k){
        int co =1;
        int sum =0;
        for(int num : nums){
            if((sum+num) > perk){
                co++;
                sum = num;
            }else{
                sum +=num;
            }
        }
        return co <=k;
    }
}