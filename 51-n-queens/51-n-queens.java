class Solution {
    
    List<List<String>> allValidConfigs = new ArrayList<>();
    int[][] blocked;
    int[] dir = new int[]{1, 1, -1, -1};
    int[] dic = new int[]{1, -1, 1, -1};
    
    public List<List<String>> solveNQueens(int n) {
        this.blocked = new int[n][n];
        List<String> blankBoard = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String blankRow = "";
            for (int j = 0; j < n; j++) {
                blankRow += ".";
            }
            blankBoard.add(blankRow);
        }
        
        backtrack(0, n, blankBoard);
        
        return allValidConfigs;
    }
    
    private void backtrack(int row, int n, List<String> board) {
        // System.out.println(n + " " + board);
        // for (int[] a : blocked) System.out.println(Arrays.toString(a));
        if (n == 0) {
            List<String> validConfig = new ArrayList<>(board);
            allValidConfigs.add(validConfig);
        }
        
        int size = board.size();
        if (row >= size) return;
        
        for (int j = 0; j < size; j++) {
            if (blocked[row][j] == 0) {
                adjustQueen(row, j, board, n, 0);
                    
                backtrack(row+1, n-1, board);
                    
                adjustQueen(row, j, board, n, 1);
            }
        }
    }
    
    private void adjustQueen(int i, int j, List<String> board, int n, int flag) {
        String curRow = board.get(i);
        if (flag == 0) curRow = curRow.substring(0, j) + "Q" + curRow.substring(j+1);
        else curRow = curRow.substring(0, j) + "." + curRow.substring(j+1);
        
        board.set(i, curRow);
        int size = board.size();
        
        for (int c = 0; c < size; c++) {
            blocked[i][c] += flag == 0 ? n : -n;
            blocked[c][j] += flag == 0 ? n : -n;
        }
        
        for (int t = 0; t < 4; t++) {
            int r1 = i, c1 = j;
            while (r1 >= 0 && r1 < size && c1 >= 0 && c1 < size) {
                blocked[r1][c1] += flag == 0 ? n : -n;
                r1 = r1 + dir[t];
                c1 = c1 + dic[t];
            }
        }
    }
}