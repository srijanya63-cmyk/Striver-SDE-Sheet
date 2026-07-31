class Solution {

    public int findMaximumXOR(int[] nums) {

        int maxXor = 0;

        for (int bit = 31; bit >= 0; bit--) {

            HashSet<Integer> set = new HashSet<>();

            for (int num : nums) {
                set.add(num >> bit);
            }

            int candidate = (maxXor << 1) | 1;

            boolean found = false;

            for (int prefix : set) {
                if (set.contains(prefix ^ candidate)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                maxXor = candidate;
            } else {
                maxXor = candidate - 1;
            }
        }

        return maxXor;
    }
}