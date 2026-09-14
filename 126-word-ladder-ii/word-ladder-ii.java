import java.util.*;

class Solution {

    public List<List<String>> findLadders(
            String beginWord,
            String endWord,
            List<String> wordList) {

        Set<String> words = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();

        if (!words.contains(endWord)) {
            return result;
        }

        // Stores all parents of a word that belong
        // to the shortest path.
        Map<String, List<String>> parents = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;

        // BFS
        while (!queue.isEmpty() && !found) {

            int size = queue.size();

            // Words visited in the current level
            Set<String> levelVisited = new HashSet<>();

            for (int k = 0; k < size; k++) {

                String word = queue.poll();

                for (int i = 0; i < word.length(); i++) {

                    char[] chars = word.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {

                        if (c == chars[i]) {
                            continue;
                        }

                        chars[i] = c;
                        String next = new String(chars);

                        if (!words.contains(next)) {
                            continue;
                        }

                        // Don't use words from previous levels
                        if (visited.contains(next)) {
                            continue;
                        }

                        // Add current word as a parent
                        parents
                            .computeIfAbsent(next, x -> new ArrayList<>())
                            .add(word);

                        if (!levelVisited.contains(next)) {
                            levelVisited.add(next);
                            queue.offer(next);
                        }

                        if (next.equals(endWord)) {
                            found = true;
                        }
                    }
                }
            }

            // Mark visited only AFTER completing the level
            visited.addAll(levelVisited);
        }

        if (!found) {
            return result;
        }

        // DFS to construct all shortest paths
        List<String> path = new ArrayList<>();
        path.add(endWord);

        dfs(endWord, beginWord, parents, path, result);

        return result;
    }

    private void dfs(
            String word,
            String beginWord,
            Map<String, List<String>> parents,
            List<String> path,
            List<List<String>> result) {

        // Reached beginning word
        if (word.equals(beginWord)) {

            List<String> sequence = new ArrayList<>(path);
            Collections.reverse(sequence);

            result.add(sequence);
            return;
        }

        if (!parents.containsKey(word)) {
            return;
        }

        for (String parent : parents.get(word)) {

            path.add(parent);

            dfs(parent, beginWord, parents, path, result);

            path.remove(path.size() - 1);
        }
    }
}