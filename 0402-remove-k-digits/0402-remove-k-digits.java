class Solution {
    public String removeKdigits(String num, int k) {
        char[] arr = num.toCharArray();
        int n = num.length();
        Stack<Character> st = new Stack<>();
            if(n == k){
                return "0";
            }
        for(int i=0;i<n;i++){

            while(!st.isEmpty() && k>0 && st.peek() > arr[i]){
                st.pop();
                k--;

            }
            st.push(arr[i]);
            
        }
        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();

        while(sb.length() >0 && sb.charAt(0)== '0'){
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
        
    }
}