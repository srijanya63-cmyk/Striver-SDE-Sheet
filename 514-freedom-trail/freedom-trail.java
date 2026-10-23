class Solution {
    int[][] memo;
    int n, m;
    String ring, key;

    public int findRotateSteps(String ring, String key) {
        this.ring = ring;
        this.key = key;
        n = ring.length();
        m = key.length();

        memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            java.util.Arrays.fill(memo[i], -1);
        }

        return solve(0, 0);
    }

    private int solve(int i, int pos) {
        if (i == m) {
            return 0;
        }

        if (memo[i][pos] != -1) {
            return memo[i][pos];
        }

        int ans = Integer.MAX_VALUE;

        for (int k = 0; k < n; k++) {
            if (ring.charAt(k) == key.charAt(i)) {
                int diff = Math.abs(pos - k);
                int rotate = Math.min(diff, n - diff);

                int steps = rotate + 1 + solve(i + 1, k);
                ans = Math.min(ans, steps);
            }
        }

        return memo[i][pos] = ans;
    }
}