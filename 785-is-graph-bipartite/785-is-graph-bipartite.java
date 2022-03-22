class Solution {
    int[] color;
    int[][] graph;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        this.color = new int[n];
        this.graph = graph;
        
        for (int i = 0; i < n; i++) {
            if (color[i] == 0 && dfs(i, 1) == false) return false;
        }
        
        return true;
    }
    
    private boolean dfs(int i, int c) {
        color[i] = c;
        
        for (int node : graph[i]) {
            if (color[node] == c) return false;
            
            if (color[node] == 0 && dfs(node, c * (-1)) == false) return false;
        }
        
        return true;
    }
}