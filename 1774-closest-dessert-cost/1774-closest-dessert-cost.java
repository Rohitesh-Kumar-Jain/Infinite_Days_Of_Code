class Solution {
    
    int ans;
    int m;
    int[] toppingCosts;
    int target;
    
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        this.m = toppingCosts.length;
        this.toppingCosts = toppingCosts;
        this.target = target;
        this.ans = baseCosts[0];
        
        for (int i : baseCosts) {
            
            int val = dp(i, 0);
            if (Math.abs(target - ans) > Math.abs(target - val)) {
                ans = val;
                
            } else if (Math.abs(target - ans) == Math.abs(target - val)) {
                ans = Math.min(ans, val);
            }
            
            // System.ou t.println(val + " " + ans);
        }
        
        return ans;
    }
    
    private int dp(int cost, int i) {
        if (cost == target) return cost;
        
        if (m == i) {
            return cost;
        }
        
        // doNothing
        int op1 = dp(cost, i + 1);
        // buy topping once
        int op2 = dp(cost + toppingCosts[i], i + 1);
        // buy topping twice
        int op3 = dp(cost + 2*toppingCosts[i], i + 1);
        
        if (Math.abs(op1 - target) > Math.abs(op2 - target)) op1 = op2;
        else if (Math.abs(op1 - target) == Math.abs(op2 - target)) op1 = Math.min(op1, op2);
        
        if (Math.abs(op1 - target) > Math.abs(op3 - target)) op1 = op3;
        else if (Math.abs(op1 - target) == Math.abs(op3 - target)) op1 = Math.min(op1, op3);
        
        return op1;
    }
}