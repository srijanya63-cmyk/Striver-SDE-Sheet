import java.util.*;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {

        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});

        maze[entrance[0]][entrance[1]] = '+';

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            int row = curr[0];
            int col = curr[1];
            int dist = curr[2];

            if ((row == 0 || row == m - 1 || col == 0 || col == n - 1)
                    && !(row == entrance[0] && col == entrance[1])) {
                return dist;
            }

            for (int[] d : dir) {

                int newRow = row + d[0];
                int newCol = col + d[1];

                if (newRow >= 0 && newRow < m &&
                    newCol >= 0 && newCol < n &&
                    maze[newRow][newCol] == '.') {

                    maze[newRow][newCol] = '+';
                    queue.offer(new int[]{newRow, newCol, dist + 1});
                }
            }
        }

        return -1;
    }
}