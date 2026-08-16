class Solution {

    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {

        // If graph is empty
        if (node == null) {
            return null;
        }

        // If already cloned
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // Create clone
        Node clone = new Node(node.val);

        // Store original → clone
        map.put(node, clone);

        // Clone all neighbours
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}

        