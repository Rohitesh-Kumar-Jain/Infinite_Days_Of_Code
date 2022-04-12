class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        DSU dsu = new DSU(n);
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String s1 = strs[i];
                String s2 = strs[j];
                
                if (isSimilar(s1, s2)) {
                    // System.out.println(s1 + " " + s2);
                    dsu.union(i, j);
                }
            }
        }
        
        Set<Integer> grps = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            grps.add(dsu.find(i));
        }
        
        return grps.size();
    }
    
    private boolean isSimilar(String s1, String s2) {
        if (s1.equals(s2)) return true;
        int firstFault = -1;
        
        int i = 0;
        while(i < s1.length()) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (firstFault == -1) {
                    firstFault = i;
                    
                } else if (s1.charAt(firstFault) != s2.charAt(i) || s2.charAt(firstFault) != s1.charAt(i)) return false;
            }
            i++;
        }
        
        return true;
    }
    
    class DSU {
        int[] root;
        int[] rank;
        
        public DSU (int n) {
            this.root = new int[n];
            this.rank = new int[n];
            
            for (int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x) {
            if (root[x] == x) return x;
            return root[x] = find(root[x]);
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX == rootY) return;
            
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
                rank[rootX] += rank[rootY];
                
            } else {
                root[rootX] = rootY;
                rank[rootY] += rank[rootX];
            }
        }
    }
}