class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int low=0;
        int max =0;
        int res=0;
        for( int high=0;high<s.length();high++){
            arr[s.charAt(high) - 'A']++;
            max = Math.max(arr[s.charAt(high)- 'A'],max);
           if(high-low+1 - max >k){
            arr[s.charAt(low)-'A']--;
            low++;
           }
           res = Math.max(res,high-low+1);
        }

        return res;   
    }
}