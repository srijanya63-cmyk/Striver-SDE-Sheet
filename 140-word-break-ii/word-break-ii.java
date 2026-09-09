class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();

        backtrack(s, 0, set, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(String s, int start, Set<String> set,
                           List<String> current, List<String> result) {

        if (start == s.length()) {
            result.add(String.join(" ", current));
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);

            if (set.contains(word)) {
                current.add(word);

                backtrack(s, end, set, current, result);

                current.remove(current.size() - 1);
            }
        }
    }
}