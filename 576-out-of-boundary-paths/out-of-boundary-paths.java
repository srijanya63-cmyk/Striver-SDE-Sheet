class Solution {
    public int findPaths(int m, int n, int maxMove,
                         int startRow, int startColumn) {

        int MOD = 1_000_000_007;
        int[][] dp = new int[m][n];

        dp[startRow][startColumn] = 1;

        int ans = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int move = 1; move <= maxMove; move++) {
            int[][] next = new int[m][n];

            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {

                    if (dp[r][c] == 0) {
                        continue;
                    }

                    for (int[] d : dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];

                        if (nr < 0 || nr >= m ||
                            nc < 0 || nc >= n) {
                            ans = (ans + dp[r][c]) % MOD;
                        } else {
                            next[nr][nc] =
                                (next[nr][nc] + dp[r][c]) % MOD;
                        }
                    }
                }
            }

            dp = next;
        }

        return ans;
    }
}