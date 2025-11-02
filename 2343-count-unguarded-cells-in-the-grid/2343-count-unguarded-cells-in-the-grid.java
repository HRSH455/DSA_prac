class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n]; // 0 = empty, 1 = guard, 2 = wall, 3 = guarded
        
        // Place guards and walls
        for (int[] g : guards) grid[g[0]][g[1]] = 1;
        for (int[] w : walls) grid[w[0]][w[1]] = 2;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // Sweep out from each guard in all 4 directions
        for (int[] g : guards) {
            for (int d = 0; d < 4; d++) {
                int r = g[0] + dr[d], c = g[1] + dc[d];
                while (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] != 1 && grid[r][c] != 2) {
                    if (grid[r][c] == 0) grid[r][c] = 3; // mark as guarded
                    r += dr[d];
                    c += dc[d];
                }
            }
        }

        // Count unguarded and unoccupied cells
        int ans = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 0)
                    ans++;
        return ans;
    }
}
