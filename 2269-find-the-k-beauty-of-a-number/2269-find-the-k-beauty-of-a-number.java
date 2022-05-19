class Solution {
    public int divisorSubstrings(int num, int k) {
        String s = Integer.toString(num);
        int k_beauty = 0;
        
        for (int i = 0; i <= s.length() - k; i++) {
            int cur = Integer.parseInt(s.substring(i, i + k));
            if (cur != 0 && num % cur == 0) k_beauty++;
        }
        
        return k_beauty;
    }
}