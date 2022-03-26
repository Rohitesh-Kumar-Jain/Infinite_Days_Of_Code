class Solution {
    public boolean equationsPossible(String[] equations) {
        
        DSU dsu = new DSU(26);
        List<String> equals = new ArrayList<>();
        List<String> nots = new ArrayList<>();
        
        for (String s : equations) {
            if (s.charAt(1) == '!') nots.add(s);
            else equals.add(s);
        }
        
        for (String s : equals) {
            dsu.union(s.charAt(0) - 'a', s.charAt(3) - 'a');
        }
        
        for (String s : nots) {
            if (dsu.isConnected(s.charAt(0) - 'a', s.charAt(3) - 'a')) return false;
        }
        
        return true;
    }
    
    class DSU {
        
        int[] root;
        int[] rank;
        
        public DSU(int n) {
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
            int RootX = find(x);
            int RootY = find(y);
            
            if (RootX == RootY) return;
            
            if (rank[RootX] > rank[RootY]) {
                root[RootY] = RootX;
                
            } else if (rank[RootX] < rank[RootY]) {
                root[RootY] = RootX;
                
            } else {
                root[RootY] = RootX;
                rank[RootX]++;
            }
        }
        
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}