class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] prefix = new int[n+1];
        int minSum =Integer.MAX_VALUE;
        boolean found = false;
        for(int i=0;i<nums.size();i++){
            prefix[i+1] = prefix[i] + nums.get(i);
        }
        for(int s =l;s<=r;s++){
            for(int start =0;start+s <=n;start++){
                int end = start+s;
                int windSum = prefix[end] - prefix[start];
                if(windSum >0){
                    minSum = Math.min(windSum,minSum);
                    found = true;
                }
            }
        }
        return (found) ?  minSum : -1;


        
    }
}