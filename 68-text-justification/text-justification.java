class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {

            // Find how many words can fit in this line
            int j = i + 1;
            int lineLength = words[i].length();

            while (j < words.length &&
                   lineLength + 1 + words[j].length() <= maxWidth) {

                lineLength += 1 + words[j].length();
                j++;
            }

            int numberOfWords = j - i;

            // Case 1: Last line
            if (j == words.length) {

                StringBuilder line = new StringBuilder();

                for (int k = i; k < j; k++) {
                    if (k > i) {
                        line.append(" ");
                    }
                    line.append(words[k]);
                }

                while (line.length() < maxWidth) {
                    line.append(" ");
                }

                result.add(line.toString());
            }

            // Case 2: Only one word
            else if (numberOfWords == 1) {

                StringBuilder line = new StringBuilder(words[i]);

                while (line.length() < maxWidth) {
                    line.append(" ");
                }

                result.add(line.toString());
            }

            // Case 3: Normal line
            else {

                int totalCharacters = 0;

                for (int k = i; k < j; k++) {
                    totalCharacters += words[k].length();
                }

                int totalSpaces = maxWidth - totalCharacters;
                int gaps = numberOfWords - 1;

                int spacesPerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                StringBuilder line = new StringBuilder();

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {

                        int spaces = spacesPerGap;

                        // Extra spaces go to the left gaps
                        if (k - i < extraSpaces) {
                            spaces++;
                        }

                        for (int s = 0; s < spaces; s++) {
                            line.append(" ");
                        }
                    }
                }

                result.add(line.toString());
            }

            i = j;
        }

        return result;
    }
}