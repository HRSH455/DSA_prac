class Solution {
    public boolean lemonadeChange(int[] bills) {
        int bill_5 =0;
        int bill_10 =0;
        for(int i=0;i<bills.length;i++){
            if(bills[i] == 5){
                bill_5 ++;
            }else if(bills[i] == 10){
                if(bill_5 == 0) return false;
                bill_5 --;
                bill_10 ++;
            }else if(bills[i] == 20){
                if(bill_5 >=1 && bill_10 >=1){
                    bill_5--;
                    bill_10--;
                }else if(bill_5 >= 3){
                    bill_5 = bill_5-3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}