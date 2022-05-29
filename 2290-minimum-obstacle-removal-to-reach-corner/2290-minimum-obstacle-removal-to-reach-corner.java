class Solution {
    
    int[] dir = new int[]{-1, 0, 1, 0};
    int[] dic = new int[]{0, 1, 0, -1};
    
    Queue<int[]> bfs;
    boolean[][] added;
    int m, n;
    
    public int minimumObstacles(int[][] grid) {
        int ans = 0;
        bfs = new LinkedList<>();
        bfs.add(new int[]{0, 0});
        m = grid.length; n = grid[0].length;
        added = new boolean[m][n];
        added[0][0] = true;
        
        while(bfs.size() > 0) {
            int t = bfs.size();
            for (int z = 0; z < t; z++) {
                int[] cur = bfs.poll();

                int r = cur[0], c = cur[1];
                
                for (int i = 0; i < 4; i++) {
                    int r1 = r + dir[i], c1 = c + dic[i];
                    if (r1 < 0 || c1 < 0 || r1 >= m || c1 >= n || added[r1][c1] == true) continue;
                    
                    if (dfs(r1, c1, grid) == true) return ans;
                }
            }
            ans++;
        }
        
        return ans;
    }
    
    private boolean dfs(int r, int c, int[][] grid) {
        if (r < 0 || c < 0 || r >= m || c >= n || added[r][c] == true) return false;
        if (r == m - 1 && c == n - 1) return true;
        
        added[r][c] = true;
        bfs.add(new int[]{r, c});
        boolean flag = false;
        
        if (grid[r][c] == 1) return false;
        
        for (int i = 0; i < 4; i++) {
            int r1 = r + dir[i], c1 = c + dic[i];
            flag = flag || dfs(r1, c1, grid);
        }
        
        return flag;
    }
}