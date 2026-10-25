
import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;

        if (stones[1] != 1) return false;

        Map<Integer, Set<Integer>> dp = new HashMap<>();

        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }

        dp.get(0).add(0);

        for (int stone : stones) {
            for (int k : dp.get(stone)) {
                for (int jump = k - 1; jump <= k + 1; jump++) {
                    if (jump <= 0) continue;

                    int next = stone + jump;

                    if (dp.containsKey(next)) {
                        dp.get(next).add(jump);
                    }
                }
            }
        }

        return !dp.get(stones[n - 1]).isEmpty();
    }
}
