class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] time = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                time[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, time, i, j, 0);
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (time[i][j] == Integer.MAX_VALUE) {
                        return -1;
                    }
                    ans = Math.max(ans, time[i][j]);
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] grid, int[][] time, int r, int c, int currentTime) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return;
        }

        if (grid[r][c] == 0) {
            return;
        }

        if (currentTime >= time[r][c]) {
            return;
        }

        time[r][c] = currentTime;

        dfs(grid, time, r + 1, c, currentTime + 1);
        dfs(grid, time, r - 1, c, currentTime + 1);
        dfs(grid, time, r, c + 1, currentTime + 1);
        dfs(grid, time, r, c - 1, currentTime + 1);
    }
}