class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int num : nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        int i=0;
        int[] res = new int[2];
        for(int k:hm.keySet()){
            if(hm.get(k) == 2){
                res[i++] = k;
            }
        }
        return res;
        

        
    }
}