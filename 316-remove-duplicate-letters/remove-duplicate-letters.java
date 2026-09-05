import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {

        int[] freq = new int[26];

        // Count frequency
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] used = new boolean[26];

        for (char ch : s.toCharArray()) {

            // This character is already in our answer
            if (used[ch - 'a']) {
                freq[ch - 'a']--;
                continue;
            }

            // Try to remove bigger characters
            while (!stack.isEmpty()
                    && stack.peek() > ch
                    && freq[stack.peek() - 'a'] > 0) {

                char removed = stack.pop();
                used[removed - 'a'] = false;
            }

            stack.push(ch);
            used[ch - 'a'] = true;

            freq[ch - 'a']--;
        }

        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }
}