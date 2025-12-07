class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int mi = Integer.MIN_VALUE;
        for(int num : weights){
            mi = Math.max(num,mi);
        }
        int total =0;
        for(int num : weights){
            total +=num;
        }
        while(mi<=total){
            int mid = mi+(total-mi)/2;
            if(canShip(weights,days,mid)){
                total = mid-1;
            }else{
                mi = mid+1;
            }
            
        }
        return mi;
    }
    public boolean canShip(int[] weights,int days,int capacity){
        int dayC =1;
        int currL =0;
        for(int w: weights){
            if(currL+w > capacity){
                dayC++;
                currL =0;
            }
            currL +=w;
            if(dayC > days){
                return false;
            }
        }
        return true;
    }

}