
class Solution {
    static final int MOD = 1_000_000_007;

    public int numDecodings(String s) {
        int n = s.length();

        long prev2 = 1;
        long prev1 = ways(s.charAt(0));

        for (int i = 1; i < n; i++) {
            char curr = s.charAt(i);
            char prev = s.charAt(i - 1);

            long currWays = (ways(curr) * prev1) % MOD;

            currWays = (currWays +
                (ways(prev, curr) * prev2) % MOD) % MOD;

            prev2 = prev1;
            prev1 = currWays;
        }

        return (int) prev1;
    }

    private long ways(char c) {
        if (c == '*') return 9;
        if (c == '0') return 0;
        return 1;
    }

    private long ways(char a, char b) {
        if (a == '*' && b == '*') return 15;

        if (a == '*') {
            return (b >= '0' && b <= '6') ? 2 : 1;
        }

        if (b == '*') {
            if (a == '1') return 9;
            if (a == '2') return 6;
            return 0;
        }

        int num = (a - '0') * 10 + (b - '0');

        return (num >= 10 && num <= 26) ? 1 : 0;
    }
}
