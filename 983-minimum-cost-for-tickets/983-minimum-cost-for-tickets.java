class Solution {
    
    int[] days, costs, dur;
    Map<String, Integer> memo = new HashMap<>();
    
    public int mincostTickets(int[] days, int[] costs) {
        this.days = days; this.costs = costs; this.dur = new int[]{1, 7, 30};
        
        return dp(0, -1);
    }
    
    private int dp(int i, int vali) {
        // System.out.println(i + " " + vali);
        if (i == days.length) {
            return 0;
        }
        
        String s = i + ":" + vali;
        
        if (memo.containsKey(s)) return memo.get(s);
        
        int val = Integer.MAX_VALUE;
        
        if (days[i] <= vali) return dp(i+1, vali);
        else {
            for (int j = 0; j < 3; j++) {
                int op = costs[j] + dp(i, days[i] + dur[j] - 1);
                val = Math.min(val, op);
            }
        }
        
        memo.put(s, val);
        
        return val;
    } 
}