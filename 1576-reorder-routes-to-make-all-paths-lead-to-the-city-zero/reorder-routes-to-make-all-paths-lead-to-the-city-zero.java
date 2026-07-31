class Solution {

    public int minReorder(int n, int[][] connections) {

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : connections) {

            int from = edge[0];
            int to = edge[1];

            graph[from].add(new int[]{to, 1});
            graph[to].add(new int[]{from, 0});
        }

        boolean[] visited = new boolean[n];

        return dfs(0, graph, visited);
    }

    private int dfs(int city, List<int[]>[] graph, boolean[] visited) {

        visited[city] = true;

        int changes = 0;

        for (int[] neighbor : graph[city]) {

            int nextCity = neighbor[0];
            int cost = neighbor[1];

            if (!visited[nextCity]) {

                changes += cost;
                changes += dfs(nextCity, graph, visited);
            }
        }

        return changes;
    }
}