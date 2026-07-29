import java.util.*;

class Solution {
    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int number = 0;

        for (char ch : s.toCharArray()) {

            // Build the number (handles cases like 12[a])
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }

            // Opening bracket
            else if (ch == '[') {
                countStack.push(number);
                stringStack.push(current);

                number = 0;
                current = new StringBuilder();
            }

            // Closing bracket
            else if (ch == ']') {

                int repeat = countStack.pop();
                StringBuilder previous = stringStack.pop();

                for (int i = 0; i < repeat; i++) {
                    previous.append(current);
                }

                current = previous;
            }

            // Normal character
            else {
                current.append(ch);
            }
        }

        return current.toString();
    }
}