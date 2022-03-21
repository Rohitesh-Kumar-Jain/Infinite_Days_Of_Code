class Solution {
    
    Map<Integer, List<Integer>> graph;
    int[] color;
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        this.graph = new HashMap<>();
        this.color = new int[n + 1];
        
        for (int[] dis : dislikes) {
            graph.putIfAbsent(dis[0], new ArrayList<>());
            graph.putIfAbsent(dis[1], new ArrayList<>());
            graph.get(dis[0]).add(dis[1]);
            graph.get(dis[1]).add(dis[0]);
        }
        
        for (int i = 1; i <= n; i++) {
            
            if (color[i] == 0 && dfs(i, 1) == false) return false;
        }
        
        return true;
    }
    
    private boolean dfs(int i, int c) {
        color[i] = c;
        if (graph.get(i) == null) return true;
        
        for (int node : graph.get(i)) {
            if (color[node] == c) return false;
            
            int newCol = color[i] == 1 ? 2 : 1;
            if (color[node] == 0 && dfs(node, newCol) == false) return false;
        }
        
        return true;
    }
}