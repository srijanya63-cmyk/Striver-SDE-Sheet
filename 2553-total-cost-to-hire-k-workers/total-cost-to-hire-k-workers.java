import java.util.PriorityQueue;

class Solution {

    public long totalCost(int[] costs, int k, int candidates) {

        int n = costs.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0])
                    return a[0] - b[0];
                return a[1] - b[1];
            }
        );

        int left = 0;
        int right = n - 1;

        // Add first candidates
        for (int i = 0; i < candidates && left <= right; i++) {
            pq.offer(new int[]{costs[left], left});
            left++;
        }

        // Add last candidates
        for (int i = 0; i < candidates && left <= right; i++) {
            pq.offer(new int[]{costs[right], right});
            right--;
        }

        long answer = 0;

        while (k-- > 0) {

            int[] curr = pq.poll();

            answer += curr[0];

            // Hired from left side
            if (curr[1] < left) {

                if (left <= right) {
                    pq.offer(new int[]{costs[left], left});
                    left++;
                }

            } else { // Hired from right side

                if (left <= right) {
                    pq.offer(new int[]{costs[right], right});
                    right--;
                }
            }
        }

        return answer;
    }
}