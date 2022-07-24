class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rows = new HashMap<>();
        Map<String, Integer> cols = new HashMap<>();
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            String s = "";
            String t = "";
            for (int j = 0; j < n; j++) {
                s += grid[i][j] + ":";
                t += grid[j][i] + ":";
            }
            rows.put(s, rows.getOrDefault(s, 0) + 1);
            cols.put(t, cols.getOrDefault(t, 0) + 1);
        }
        
        for (String s : rows.keySet()) {
            if (cols.containsKey(s)) {
                ans += rows.get(s) * cols.get(s);
            }
        }
        
        return ans;
    }
}