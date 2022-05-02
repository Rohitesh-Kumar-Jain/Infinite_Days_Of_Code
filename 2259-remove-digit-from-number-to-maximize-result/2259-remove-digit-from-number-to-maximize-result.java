class Solution {
    public String removeDigit(String s, char digit) {
        int len = s.length();
        s += "0";
        
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == digit && ch < s.charAt(i + 1)) {
                String ans = s.substring(0, i) + s.substring(i + 1, len);
                return ans;
            }
        }
        
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == digit) {
                String ans = s.substring(0, i) + s.substring(i + 1, len);
                return ans;
            }
        }
        
        return s;
    }
}