
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int curr = 0;
        int total = 0;

        for (int i = 2; i < n; i++) {
            if ((long) nums[i] - nums[i - 1] ==
                (long) nums[i - 1] - nums[i - 2]) {
                curr++;
                total += curr;
            } else {
                curr = 0;
            }
        }

        return total;
    }
}
