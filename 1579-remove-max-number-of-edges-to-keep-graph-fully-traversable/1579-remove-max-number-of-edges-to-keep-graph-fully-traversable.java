class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int ans = 0;
        List<int[]> type1 = new ArrayList<>();
        List<int[]> type2 = new ArrayList<>();
        List<int[]> type3 = new ArrayList<>();
        
        DSU dsu1 = new DSU(n);
        DSU dsu2 = new DSU(n);
        
        for (int[] edge : edges) {
            if (edge[0] == 1) type1.add(edge);
            else if (edge[0] == 2) type2.add(edge);
            else type3.add(edge);
        }
        
        for (int[] edge : type3) {
            boolean res1 = dsu1.union(edge[1] - 1, edge[2] - 1);
            boolean res2 = dsu2.union(edge[1] - 1, edge[2] - 1);
            if (res1 == false && res2 == false) ans++;
        }
        
        for (int[] edge : type1) {
            if (dsu1.union(edge[1] - 1, edge[2] - 1) == false) ans++;
        }
        
        for (int[] edge : type2) {
            if (dsu2.union(edge[1] - 1, edge[2] - 1) == false) ans++;
        }
        
        int root = dsu1.find(0);
        for (int i = 1; i < n; i++) {
            if (dsu1.find(i) != root) return -1;
        }
        
        root = dsu2.find(0);
        for (int i = 1; i < n; i++) {
            if (dsu2.find(i) != root) return -1;
        }
        
        return ans;
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
        
        public boolean union(int x, int y) {
            int RootX = find(x);
            int RootY = find(y);
            
            if (RootX == RootY) return false;
            
            if (rank[RootX] > rank[RootY]) {
                root[RootY] = RootX;
                
            } else if (rank[RootX] < rank[RootY]) {
                root[RootY] = RootX;
                
            } else {
                root[RootY] = RootX;
                rank[RootX]++;
            }
            
            return true;
        }
        
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}