class Solution {
    public int numberOfSubstrings(String s) {
       int l=0,c=0;
       int[] charC = new int[3];
       for(int r=0;r<s.length();r++){
        charC[s.charAt(r)-'a']++;
        while(charC[0] > 0 && charC[1]>0 && charC[2]>0){
            c += s.length() -r;
            charC[s.charAt(l) - 'a']--;
            l++;
        }
       } 
       return c;
    }
}