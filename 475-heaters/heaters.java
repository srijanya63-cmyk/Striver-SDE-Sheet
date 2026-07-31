import java.util.Arrays;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);

        int radius = 0;

        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);

            if (index < 0) {
                index = -(index + 1);
            }

            int leftDist = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int rightDist = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

            radius = Math.max(radius, Math.min(leftDist, rightDist));
        }

        return radius;
    }
}