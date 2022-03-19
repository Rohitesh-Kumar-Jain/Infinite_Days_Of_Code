class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> seen = new HashSet<>();
        Set<String> valid = new HashSet<>(wordList);
        int ans = 0;
        
        Queue<String> bfs = new LinkedList<>();
        bfs.add(beginWord);
        
        while(bfs.size() > 0) {
            int k = bfs.size();
            
            for (int t = 0; t < k; t++) {
                
                String cur = bfs.poll();
                if (seen.contains(cur)) continue;
                seen.add(cur);
                
                if (cur.equals(endWord)) return ans + 1;
                
                for (int i = 0; i < cur.length(); i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        String st = "";
                        if (i > 0) st = st + cur.substring(0, i); 
                        st = st + ch + cur.substring(i+1);
                        if (!seen.contains(st) && valid.contains(st)) bfs.add(st);
                    }
                }
            }
            ans++;
        }
        return 0;
    }
}