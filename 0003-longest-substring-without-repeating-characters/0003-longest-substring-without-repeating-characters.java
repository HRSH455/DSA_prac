class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] ind = new int[128];
        int left =0,maxlen =0;
        for(int right=0;right<s.length();right++){
            char c = s.charAt(right);
            left = Math.max(left,ind[c]);
            maxlen = Math.max(maxlen,right-left+1);
            ind[c] = right+1;
        }
        return maxlen;
        
    }
}