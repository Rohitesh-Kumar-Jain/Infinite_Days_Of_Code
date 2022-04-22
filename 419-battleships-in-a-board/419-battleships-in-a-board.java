class Solution {
    
    char[][] board;
    
    int[][] dir = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int countBattleships(char[][] board) {
        this.board = board;
        int m = board.length;
        int n = board[0].length;
        
        int ans = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    dfs(i, j);
                    ans++;
                }
            }
        }
        
        return ans;
    }
    
    private void dfs(int x, int y) {
        board[x][y] = '.';
        
        for (int i = 0; i < 4; i++) {
            int r = x + dir[i][0], c = y + dir[i][1];
            
            if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == '.') continue;
            dfs(r, c);
        }
    }
}