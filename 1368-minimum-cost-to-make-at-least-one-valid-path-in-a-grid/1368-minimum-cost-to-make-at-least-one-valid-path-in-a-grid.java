class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][][] dist = new int[m][n][4];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][][] seen = new boolean[m][n][4];
        pq.add(new int[]{0, 0, 0});
        
        for (int[][] dd : dist) for (int[] d : dd) Arrays.fill(d, Integer.MAX_VALUE);
        Arrays.fill(dist[0][0], 0);
        
        int[] dir = new int[]{0, 0, +1, -1};
        int[] dic = new int[]{1, -1, 0, 0};
        
        while(pq.size() > 0) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], d = cur[2];
            int sym = grid[x][y];
            
            if (seen[x][y][sym - 1] == true) continue;
            seen[x][y][sym - 1] = true;
            
            for (int i = 0; i < 4; i++) {
                int r = x + dir[i], c = y + dic[i];
                int nd = d;
                
                if (r < 0 || c < 0 || r >= m || c >= n) continue;
                
                if (sym - 1 != i) nd++;
                
                if (dist[r][c][i] > nd) {
                    dist[r][c][i] = nd;
                    pq.add(new int[]{r, c, nd});
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int i : dist[m - 1][n - 1]) {
            ans = Math.min(ans, i);
        }
        return ans;
    }
}