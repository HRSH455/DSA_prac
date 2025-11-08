// class Solution {
//     public String convertToTitle(int columnNumber) {
//         String sol = "";
//         while(columnNumber >0){
//             columnNumber --;
//             int dig = columnNumber%26;
//             sol = (char)(dig + 'A') + sol;
//             columnNumber /= 26;
//         }
//         return sol;
        
//     }
// }
class Solution{
    public String convertToTitle(int columnNumber){
        StringBuilder sb = new StringBuilder();
        while(columnNumber >0){
            columnNumber--;
            sb.insert(0,(char)((columnNumber % 26)+ 'A'));
            columnNumber/=26;
        }
        return sb.toString();
    }
}