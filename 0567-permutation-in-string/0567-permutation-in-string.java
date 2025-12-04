class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        
       Map<Character,Integer> hm1 = new HashMap<>();
       Map<Character,Integer> hm2 = new HashMap<>();
       for(int i=0;i<s1.length();i++){
        hm1.put(s1.charAt(i),hm1.getOrDefault(s1.charAt(i),0)+1);
        hm2.put(s2.charAt(i),hm2.getOrDefault(s2.charAt(i),0)+1);
       }
       if(hm1.equals(hm2)){
        return true;

       }
       int left =0;
       for(int right = s1.length();right<s2.length();right++){
        char charRight = s2.charAt(right);
        hm2.put(charRight,hm2.getOrDefault(charRight,0)+1);
        char charLeft = s2.charAt(left);
        hm2.put(charLeft,hm2.getOrDefault(charLeft,0)-1);
        if(hm2.get(charLeft) == 0){
            hm2.remove(charLeft);
        }
        left++; 

        if(hm1.equals(hm2)){
            return true;
        }
       }
       return false;
    }
}