class Solution {

    public String originalDigits(String s) {

        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        int[] digit = new int[10];

        digit[0] = count['z' - 'a'];
        digit[2] = count['w' - 'a'];
        digit[4] = count['u' - 'a'];
        digit[6] = count['x' - 'a'];
        digit[8] = count['g' - 'a'];

        digit[3] = count['h' - 'a'] - digit[8];
        digit[5] = count['f' - 'a'] - digit[4];
        digit[7] = count['s' - 'a'] - digit[6];

        digit[1] = count['o' - 'a'] - digit[0] - digit[2] - digit[4];

        digit[9] = count['i' - 'a'] - digit[5] - digit[6] - digit[8];

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i <= 9; i++) {
            while (digit[i]-- > 0) {
                ans.append(i);
            }
        }

        return ans.toString();
    }
}