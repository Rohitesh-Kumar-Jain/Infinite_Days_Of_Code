class Solution {
    public int minimumLines(int[][] stock) {
        int n = stock.length, ans = 1;
        if (n == 1) return 0;
        
        Arrays.sort(stock, (a, b) -> a[0] - b[0]);
        
        System.out.println(Arrays.deepToString(stock));
        
        long a = stock[1][1] - stock[0][1];
        long b = stock[1][0] - stock[0][0];
        
        for (int i = 2; i < n; i++) {
            long c = stock[i][1] - stock[i - 1][1];
            long d = stock[i][0] - stock[i - 1][0];
            
            if (a * d != b * c) ans++;
            
            // System.out.println(a + " " + b + " " + c + " " + d);
            
            a = c;
            b = d;
        }
        
        return ans;
    }
}