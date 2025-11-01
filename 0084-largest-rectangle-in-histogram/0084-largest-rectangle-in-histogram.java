class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i <= n; i++) {
            int height = (i == n) ? 0 : heights[i];
            while (!st.isEmpty() && heights[st.peek()] > height) {
                int poppedIndex = st.pop();
                int h = heights[poppedIndex];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                maxArea = Math.max(maxArea, h * width);
            }
            st.push(i);
        }
        return maxArea;
    }
}
