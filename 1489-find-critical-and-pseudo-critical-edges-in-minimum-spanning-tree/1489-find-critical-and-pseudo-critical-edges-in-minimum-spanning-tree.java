class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int len = edges.length;
        
        Map<int[], Integer> index = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int[] edge = edges[i];
            index.put(edge, i);
        }
        
        int msp = 0;
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        DSU main = new DSU(n);
        int count = 0;
        
        int i = 0;
        while(i < edges.length && count < n) {
            int[] edge = edges[i];
            if (main.union(edge[0], edge[1]) == true) {
                count++;
                msp += edge[2];
            }
            i++;
        }
        
        System.out.println(msp);
        
        for (i = 0; i < len; i++) {
            int[] cur = edges[i];
            int curIndex = index.get(cur);
            DSU dsu = new DSU(n);
            DSU include = new DSU(n);
            int cost = 0, includeCost = cur[2];
            include.union(cur[0], cur[1]);
 
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                int[] edge = edges[j];
                if (dsu.union(edge[0], edge[1]) == true) {
                    cost += edge[2];
                }
                if (include.union(edge[0], edge[1]) == true) {
                    includeCost += edge[2];
                }
            }
            if (cost != msp) critical.add(curIndex);
            else if (includeCost == msp) pseudo.add(curIndex);
        }
        
        ans.add(critical); ans.add(pseudo);
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
        
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX == rootY) return false;
            
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
                rank[rootX] += rank[rootY];
                
            } else {
                root[rootX] = rootY;
                rank[rootY] += rank[rootX];
            }
            
            return true;
        }
    }
}