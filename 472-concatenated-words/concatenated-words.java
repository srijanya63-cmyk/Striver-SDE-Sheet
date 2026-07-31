import java.util.*;

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        List<String> result = new ArrayList<>();

        for (String word : words) {
            set.remove(word);

            if (canForm(word, set, new HashMap<>())) {
                result.add(word);
            }

            set.add(word);
        }

        return result;
    }

    private boolean canForm(String word, Set<String> set, Map<String, Boolean> memo) {
        if (memo.containsKey(word)) {
            return memo.get(word);
        }

        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if (set.contains(prefix)) {
                if (set.contains(suffix) || canForm(suffix, set, memo)) {
                    memo.put(word, true);
                    return true;
                }
            }
        }

        memo.put(word, false);
        return false;
    }
}