class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length(), j = 0;
        if (m > n) return -1;
        int[] lps = createLPS(needle);
        
        for (int i = 0; i < n; i++) {
            while(j > 0 && haystack.charAt(i) != needle.charAt(j)) j = lps[j-1];
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                if (j == m) return i - m + 1;
            }
        }
        
        return -1;
    }
    
    private int[] createLPS(String needle) {
        int m = needle.length();
        int[] lps = new int[m];
        
        for (int i = 1, j = 0; i < m; i++) {
            while(j > 0 && needle.charAt(i) != needle.charAt(j)) j = lps[j - 1];
            if(needle.charAt(i) == needle.charAt(j)) lps[i] = ++j;
        }
        
        return lps;
    }
}