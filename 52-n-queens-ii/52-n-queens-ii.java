class Solution {
    
    int ans, n;
    Set<Integer> vertical, diagonal, antidiagonal;
    
    public int totalNQueens(int n) {
        ans = 0;
        this.n = n;
        vertical = new HashSet<>(); diagonal = new HashSet<>(); antidiagonal = new HashSet<>();
        backtrack(0);
        return ans;
    }
    
    private void backtrack(int row) {
        if (row == n) {
            ans++; return;
        }
        
        for (int j = 0; j < n; j++) {
            int dia = row-j;
            int anti = row+j;
            if (!vertical.contains(j) && !diagonal.contains(dia) && !antidiagonal.contains(anti)) {
                vertical.add(j); diagonal.add(dia); antidiagonal.add(anti);
                
                backtrack(row + 1);
                
                vertical.remove(j); diagonal.remove(dia); antidiagonal.remove(anti);
            }
        }
    }
}