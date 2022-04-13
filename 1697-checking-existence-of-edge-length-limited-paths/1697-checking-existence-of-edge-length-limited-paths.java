class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        Map<int[], Integer> position = new HashMap<>();
        
        for (int i = 0; i < queries.length; i++) {
            position.put(queries[i], i);
        }
        
        Arrays.sort(queries, (a, b) -> a[2] - b[2]);
        
        DSU dsu = new DSU(n);
        boolean[] ans = new boolean[queries.length];
        int j = 0;
        
        System.out.println(Arrays.deepToString(edgeList));
        System.out.println(Arrays.deepToString(queries));
        
        for (int[] q : queries) {
            int limit = q[2];
            
            while(j < edgeList.length && edgeList[j][2] < limit) {
                dsu.union(edgeList[j][0], edgeList[j][1]);
                j++;
            }
            
            ans[position.get(q)] = dsu.isConnected(q[0], q[1]);
        }
        
        return ans;
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
        
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}