class Solution {
    public List<Boolean> areConnected(int n, int t, int[][] queries) {
        DSU dsu = new DSU(n);
        
        for (int i = t + 1; i < n; i++) {
            int j = 2;
            while(i * j <= n) {
                dsu.union(i, i * j);
                j++;
            }
        }
        
        List<Boolean> ans = new ArrayList<>();
        
        for (int[] q : queries) {
            ans.add(dsu.isConnected(q[0], q[1]));
        }
        
        return ans;
    }
    
    class DSU {
        int[] root;
        int[] rank;
        
        public DSU (int n) {
            this.root = new int[n + 1];
            this.rank = new int[n + 1];
            
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
        
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}