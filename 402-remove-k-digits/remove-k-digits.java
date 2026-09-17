class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder st = new StringBuilder();

        for (char digit : num.toCharArray()) {

            // Remove larger digits from the left
            while (st.length() > 0 && k > 0 &&
                   st.charAt(st.length() - 1) > digit) {
                st.deleteCharAt(st.length() - 1);
                k--;
            }

            st.append(digit);
        }

        // If k digits are still left, remove from the end
        while (k > 0 && st.length() > 0) {
            st.deleteCharAt(st.length() - 1);
            k--;
        }

        // Remove leading zeros
        int i = 0;
        while (i < st.length() && st.charAt(i) == '0') {
            i++;
        }

        String ans = st.substring(i);

        return ans.length() == 0 ? "0" : ans;
    }
}