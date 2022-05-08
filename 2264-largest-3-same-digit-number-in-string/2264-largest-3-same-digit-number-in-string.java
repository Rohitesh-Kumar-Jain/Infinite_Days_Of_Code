class Solution {
    public String largestGoodInteger(String num) {
        String ans = "";
        int max = -1;
        
        for (int i = 0; i < num.length() - 2; i++) {
             char ch1 = num.charAt(i), ch2 = num.charAt(i + 1), ch3 = num.charAt(i + 2);
            
            if (ch1 == ch2 && ch2 == ch3 && ch1 == ch3) {
                if (max < (ch1 - '0')) {
                    max = (ch1 - '0');
                    ans = "" + ch1 + ch2 + ch3;
                }
            }
        }
        
        return ans;
    }
}