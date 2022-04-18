class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] dist = new int[n][k + 1];
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[][] seen = new boolean[n][k + 1];
        pq.add(new int[]{src, 0, 0});
        
        while(pq.size() > 0) {
            // for (int[] arr : pq) System.out.print(Arrays.toString(arr) + " ");
            System.out.println();
            int[] arr = pq.poll();
            int cur = arr[0], d = arr[1], stops = arr[2];
            
            if (stops > k || seen[cur][stops] == true) continue;
            seen[cur][stops] = true;
            
            if (graph.get(cur) == null) continue;
            
            for (int[] node : graph.get(cur)) {
                if (dist[node[0]][stops] > d + node[1]) {
                    dist[node[0]][stops] = d + node[1];
                }
                pq.add(new int[]{node[0], dist[node[0]][stops], stops + 1});
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int val : dist[dst]) {
            ans = Math.min(ans, val);
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}