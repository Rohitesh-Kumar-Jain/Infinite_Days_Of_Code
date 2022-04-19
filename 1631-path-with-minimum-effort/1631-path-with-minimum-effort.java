class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        // System.out.println(n + " " + m);
        int[][] dist = new int[n][m];
        for (int[] dis : dist) Arrays.fill(dis, Integer.MAX_VALUE);
        dist[0][0] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] seen = new boolean[n][m];
        pq.add(new int[]{0, 0, 0});
        
        int[] dir = new int[]{-1, 0, 1, 0};
        int[] dic = new int[]{0, 1, 0, -1};
        
        while(pq.size() > 0) {
            int[] cur = pq.poll();
            int r = cur[0], c = cur[1], d = cur[2];
            
            if (seen[r][c] == true) continue;
            seen[r][c] = true;
            
            for (int i = 0; i < 4; i++) {
                int x = r + dir[i], y = c + dic[i];
                if (x >= n || y >= m || x < 0 || y < 0) continue;
                
                int newd = d;
                newd = Math.max(Math.abs(heights[x][y] - heights[r][c]), newd);
                
                if (dist[x][y] > newd) {
                    dist[x][y] = newd;
                }
                
                pq.add(new int[]{x, y, newd});
            }
        }
        
        // for (int[] a : dist) System.out.println(Arrays.toString(a));
        
        return dist[n - 1][m - 1];
    }
}