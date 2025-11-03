class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] heights = new int[col];
        int maxArea =0;
        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j] == '1'){
                    heights[j] +=1;
                }else{
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea,MaximumAreaRectangle(heights));
        } 
        return maxArea;
    }
    public int MaximumAreaRectangle(int[] heights){
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<=n;i++){
            int h = (i ==n) ? 0 : heights[i];
            while(!st.isEmpty() && h< heights[st.peek()]){
                int height = heights[st.pop()];
                int width = (st.isEmpty())? i : i- st.peek()-1;
                maxArea = Math.max(maxArea, height * width);
            }
            st.push(i);
        }
        return maxArea;
    }
}