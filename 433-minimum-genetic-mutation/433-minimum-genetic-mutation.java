class Solution {
    public int minMutation(String start, String end, String[] bank) {
        int ans = 0;
        Set<String> seen = new HashSet<>();
        Set<String> valid = new HashSet<>();
        for (String b : bank) valid.add(b);
        valid.add(start);
        String[] gene = new String[]{"A", "C", "G", "T"};
        
        Queue<String> bfs = new LinkedList<>();
        bfs.add(start);
        
        while(bfs.size() > 0) {
            
            int k = bfs.size();
            for (int t = 0; t < k; t++) {
                String s = bfs.poll();
                
                // System.out.println(s);
                
                if (seen.contains(s) || !valid.contains(s)) continue;
                seen.add(s);
                
                if (s.equals(end)) return ans;

                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 4; j++) {
                        String next = s.substring(0, i) + gene[j] + s.substring(i + 1);
                        bfs.add(next);
                    }
                }
            }
            // System.out.println();
            ans++;
        }
        
        return -1;
    }
}