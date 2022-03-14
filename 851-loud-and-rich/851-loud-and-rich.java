class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        int[] indegree = new int[n];
        
        for (int[] rich : richer) {
            graph.putIfAbsent(rich[0], new ArrayList<>());
            graph.get(rich[0]).add(rich[1]);
            indegree[rich[1]]++;
        }
        
        int[] ans = new int[n];
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        while(q.size() > 0) {
            
            int k = q.size();
            for (int t = 0; t < k; t++) {
                
                int cur = q.poll();
                if (!map.containsKey(cur)) {
                    map.put(cur, cur);
                }
                ans[cur] = map.get(cur);
                
                if (graph.get(cur) == null) continue;
                
                for (int node : graph.get(cur)) {
                    if (quiet[node]  > quiet[cur]) {
                        quiet[node] = quiet[cur];
                        map.put(node, map.get(cur));
                    }
                    indegree[node]--;
                    if (indegree[node] == 0) q.add(node);
                }
            }
        }
        
        return ans;
        
    }
}