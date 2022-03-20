class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int ans = Integer.MAX_VALUE;
        
        for (int i = 1; i <= 6; i++) {
            int op1 = 0;
            boolean flag1 = true;
            for (int j = 0; j < tops.length; j++) {
                if (tops[j] != i && bottoms[j] == i) {
                    op1++;
                    
                } else if (tops[j] != i && bottoms[j] != i) {
                    flag1 = false;
                    break;
                }
            }
            
            boolean flag2 = true;
            int op2 = 0;
            for (int j = 0; j < tops.length; j++) {
                if (bottoms[j] != i && tops[j] == i) {
                    op2++;
                    
                } else if (bottoms[j] != i && tops[j] != i) {
                    flag2 = false;
                    break;
                }
            }
            
            if (flag1 == true) ans = Math.min(ans, op1);
            if (flag2 == true) ans = Math.min(ans, op2);
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}