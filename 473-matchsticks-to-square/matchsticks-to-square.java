import java.util.*;

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int total = 0;

        for (int stick : matchsticks) {
            total += stick;
        }

        if (total % 4 != 0) {
            return false;
        }

        Arrays.sort(matchsticks);
        reverse(matchsticks);

        int target = total / 4;
        int[] sides = new int[4];

        return backtrack(matchsticks, 0, sides, target);
    }

    private boolean backtrack(int[] sticks, int index,
                              int[] sides, int target) {
        if (index == sticks.length) {
            return sides[0] == target &&
                   sides[1] == target &&
                   sides[2] == target &&
                   sides[3] == target;
        }

        int stick = sticks[index];

        for (int i = 0; i < 4; i++) {
            if (sides[i] + stick <= target) {
                sides[i] += stick;

                if (backtrack(sticks, index + 1, sides, target)) {
                    return true;
                }

                sides[i] -= stick;
            }

            if (sides[i] == 0) {
                break;
            }
        }

        return false;
    }

    private void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}