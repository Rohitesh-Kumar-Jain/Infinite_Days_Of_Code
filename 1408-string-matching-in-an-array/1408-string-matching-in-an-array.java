class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++) {
            String t = words[i];
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                String s = words[j];
                
                if (match(s, t) == true) {
                    ans.add(t); break;
                }
            }
        }
        
        return ans;
    }
    
    private boolean match(String s, String t) {
        
        int slen = s.length(), tlen = t.length();
        if (tlen > slen) return false;
        
        for (int i = 0; i < slen; i++) {
            if (s.charAt(i) == t.charAt(0)) {
                int j = i, l = 0;
                while(j < slen && l < tlen && s.charAt(j) == t.charAt(l)) {
                    j++; l++;
                }
                if (l == tlen) return true;
            }
        }
        
        return false;
    }
}