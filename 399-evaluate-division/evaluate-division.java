class Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, List<Pair>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {

            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(new Pair(v, value));
            graph.get(v).add(new Pair(u, 1.0 / value));
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {

            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
                ans[i] = -1.0;
            } else if (src.equals(dest)) {
                ans[i] = 1.0;
            } else {
                ans[i] = dfs(src, dest, graph, new HashSet<>(), 1.0);
            }
        }

        return ans;
    }

    private double dfs(String curr, String target,
                       Map<String, List<Pair>> graph,
                       Set<String> visited,
                       double product) {

        if (curr.equals(target)) {
            return product;
        }

        visited.add(curr);

        for (Pair neighbor : graph.get(curr)) {

            if (!visited.contains(neighbor.node)) {

                double result = dfs(
                        neighbor.node,
                        target,
                        graph,
                        visited,
                        product * neighbor.weight);

                if (result != -1.0) {
                    return result;
                }
            }
        }

        return -1.0;
    }

    class Pair {

        String node;
        double weight;

        Pair(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}