class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int maxc=0;
        if(Arrays.equals(nums1,nums2)){
            return n;
        }       
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int c=0;
                while( i+c < n && j+c < m && nums1[i+c] == nums2[j+c]){
                    c++;
                }
                maxc = Math.max(c,maxc);

            }
        }
        return maxc;
        
    }
}