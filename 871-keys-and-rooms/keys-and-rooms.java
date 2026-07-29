class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];

        dfs(0, rooms, visited);

        // Check if every room was visited
        for (boolean room : visited) {
            if (!room) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {

        if (visited[room]) {
            return;
        }

        visited[room] = true;

        for (int key : rooms.get(room)) {
            dfs(key, rooms, visited);
        }
    }
}