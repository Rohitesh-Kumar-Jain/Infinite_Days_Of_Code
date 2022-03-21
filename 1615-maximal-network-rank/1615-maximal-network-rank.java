class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int val = graph.get(i).size() + graph.get(j).size();
                    
                    for (int node : graph.get(i)) {
                        if (node == j) {
                            val--;
                            break;
                        }
                    }
                    
                    ans = Math.max(ans, val);
                }
            }
        }
        
        return ans;
    }
}