class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int ans = 0;
        boolean[][] open = new boolean[n][n];
        
        for (int[] d : dig) {
            open[d[0]][d[1]] = true;
        }
        
        for (int[] art : artifacts) {
            int x1 = art[0], y1 = art[1], x2 = art[2], y2 = art[3];
            
            // System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
            
            boolean res = open[x1][y1];
            int r = x2, c = y2;
            while (r > x1) {
                res = res && open[r][y1];
                if (res == false) break;
                r--;
            }
            while (c > y1) {
                res = res && open[x1][c];
                if (res == false) break;
                c--;
            }
            if (x2 > x1 && y2 > y1) res = res && open[x2][y2];
            
            if (res == true) ans++;
        }
        
        return ans;
    }
}