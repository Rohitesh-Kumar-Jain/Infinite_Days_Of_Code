class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];
        
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        Set<Integer> set = new HashSet<>();
        
        pq.add(new int[]{0, 0, 0});
        
        while(pq.size() > 0) {
            int[] arr = pq.poll();
            int r = arr[0], c = arr[1], d = arr[2];
            int k = r*n + c;
            if (set.contains(k)) continue;
            set.add(k);
            
            d = Math.max(d, grid[r][c]);
            dist[r][c] = Math.min(dist[r][c], d);
            
            if (r == n - 1 && c == n - 1) return dist[r][c];
            
            int dir[] = new int[]{-1, 0, 1, 0};
            int dic[] = new int[]{0, 1, 0, -1};
            
            for (int j = 0; j < 4; j++) {
                int r1 = r + dir[j];
                int c1 = c + dic[j];
                
                if (r1 < 0 || c1 < 0 || r1 >= n || c1 >= n) continue;
                pq.add(new int[]{r1, c1, d});
            }
        }
        
        return dist[n - 1][n - 1];
    }
}