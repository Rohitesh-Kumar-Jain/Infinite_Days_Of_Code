class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() > goal.length()) return false;
        goal = goal + goal;
        return kmp(goal, s);
    }
    
    private boolean kmp(String text, String pattern) {
        int[] lps = constructLPS(pattern);
        int n = text.length();
        
        for (int i = 0, j = 0; i < n; i++) {
            while(j > 0 && text.charAt(i) != pattern.charAt(j)) j = lps[j - 1];
            if (text.charAt(i) == pattern.charAt(j)) j++;
            if (j == pattern.length()) return true;
        }
        
        return false;
    }
    
    private int[] constructLPS(String s) {
        int n = s.length();
        int[] lps = new int[n];
        
        for (int i = 1, j = 0; i < n; i++) {
            while(j > 0 && s.charAt(i) != s.charAt(j)) j = lps[j - 1];
            if (s.charAt(i) == s.charAt(j)) lps[i] = ++j;
        }
        
        return lps;
    }
}