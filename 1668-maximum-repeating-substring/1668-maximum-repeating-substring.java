class Solution {
    public int maxRepeating(String s, String word) {
        int ans = 0;
        String a = "";
        
        while(true) {
            if (match(s, a) == false) break;
            ans++;
            a = a + word;
        }
        
        return ans - 1;
    }
    
    private boolean match(String s, String word) {
        int n = s.length(), m = word.length();
        if (m == 0) return true;
        if (m > n) return false;
        int[] lps = createLPS(word);
        
        for (int i = 0, j = 0; i < n; i++) {
            while(j > 0 && s.charAt(i) != word.charAt(j)) j = lps[j-1];
            if (s.charAt(i) == word.charAt(j)) {
                if (++j == m) return true;
            }
        }
        
        return false;
    }
    
    private int[] createLPS(String word) {
        int n = word.length();
        int[] lps = new int[n];
        
        for (int i = 1, j = 0; i < n; i++) {
            while(j > 0 && word.charAt(i) != word.charAt(j)) j = lps[j-1];
            if (word.charAt(i) == word.charAt(j)) lps[i] = ++j;
        }
        
        return lps;
    }
}