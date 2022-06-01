class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] grid = new int[m][n];
        int largest = 0;
        
        for (int j = 0; j < n; j++) {
            grid[0][j] = matrix[0][j] - '0';
        }
        
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < m; i++) {
                int val = matrix[i][j] - '0';
                if (val == 0) grid[i][j] = 0;
                else grid[i][j] = grid[i-1][j] + 1;
            }
        }
        
        int[][] ple = new int[m][n];
        int[][] nle = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            Stack<Integer> stk_ple = new Stack<>();
            Stack<Integer> stk_nle = new Stack<>();
            
            for (int j = 0; j < n; j++) {
                nle[i][j] = n - j;
            }
            
            for (int j = 0; j < n; j++) {
                while(!stk_ple.empty() && grid[i][stk_ple.peek()] > grid[i][j]) {
                    stk_ple.pop();
                }
                ple[i][j] = stk_ple.empty() ? j+1 : j - stk_ple.peek();
                stk_ple.push(j);
            }
            
            for (int j = 0; j < n; j++) {
                while(!stk_nle.empty() && grid[i][stk_nle.peek()] > grid[i][j]) {
                    int next = stk_nle.pop();
                    nle[i][next] = j - next;
                }
                stk_nle.push(j);
            }
            
            int rowMax = 0;
            for (int j = 0; j < n; j++) {
                int val = grid[i][j] * (nle[i][j] + ple[i][j] - 1);
                rowMax = Math.max(rowMax, val);
            }
            
            largest = Math.max(rowMax, largest);
        }
        
        return largest;
    }
}