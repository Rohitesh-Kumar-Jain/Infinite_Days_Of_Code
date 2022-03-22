class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        DSU dsu = new DSU(n);
        
        for (int i = 0; i < n; i++) {
            if (graph[i].length == 0) continue;
            int opposite = graph[i][0];
            for (int node : graph[i]) {
                if (dsu.isConnected(i, node) == true) return false;
                dsu.union(opposite, node);
            }
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