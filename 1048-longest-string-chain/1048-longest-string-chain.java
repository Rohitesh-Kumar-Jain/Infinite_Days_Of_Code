class Solution {
    
    Set<String> set;
    Map<String, Integer> memo;
    
    public int longestStrChain(String[] words) {
        this.set = new HashSet<>();
        this.memo = new HashMap<>();
        for (String word : words) set.add(word);
        
        int ans = 0;
        
        for (String word : words) {
            ans = Math.max(ans, dp(word));
        }
        
        return ans;
    }
    
    private int dp(String s) {
        if (s.length() == 0) return 0;
        if (!set.contains(s)) return 0;
        if (memo.containsKey(s)) return memo.get(s);
        
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            String newS = s.substring(0, i) + s.substring(i + 1, s.length());
            
            val = Math.max(val, dp(newS) + 1);
        }
        
        memo.put(s, val);
        
        return val;
    }
}