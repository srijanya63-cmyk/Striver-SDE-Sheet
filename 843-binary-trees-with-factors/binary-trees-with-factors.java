
import java.util.*;

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);

        int n = arr.length;
        long MOD = 1_000_000_007L;

        HashMap<Integer, Integer> map = new HashMap<>();
        long[] dp = new long[n];

        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
            dp[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int right = arr[i] / arr[j];

                    if (map.containsKey(right)) {
                        int k = map.get(right);

                        dp[i] = (dp[i] + dp[j] * dp[k]) % MOD;
                    }
                }
            }
        }

        long ans = 0;

        for (long ways : dp) {
            ans = (ans + ways) % MOD;
        }

        return (int) ans;
    }
}
