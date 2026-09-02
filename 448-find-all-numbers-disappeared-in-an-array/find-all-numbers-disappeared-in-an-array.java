class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        // Mark the numbers that are present
        for (int i = 0; i < nums.length; i++) {

            int index = Math.abs(nums[i]) - 1;

            nums[index] = -Math.abs(nums[index]);
        }

        // Find the numbers that are missing
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}