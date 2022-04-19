class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        
        Map<Integer, List<int[]>> graph = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }
        
        pq.add(new int[]{k, 0});
        
        while(pq.size() > 0) {
            int[] arr = pq.poll();
            int cur = arr[0], d = arr[1];
            
            if (seen.contains(cur)) continue;
            seen.add(cur);
            
            if (graph.get(cur) == null) continue;
            
            for (int adj[] : graph.get(cur)) {
                int node = adj[0], cost = adj[1];
                if (dist[node] > d + cost) {
                    dist[node] = d + cost;
                }
                pq.add(new int[]{node, d + cost});
            }
        }
        
        int ans = 0;
        for (int j = 1; j <= n; j++) {
            int i = dist[j];
            ans = Math.max(i, ans);
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}