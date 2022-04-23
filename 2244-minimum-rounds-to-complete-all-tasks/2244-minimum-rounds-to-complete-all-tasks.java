class Solution {
    public int minimumRounds(int[] tasks) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : tasks) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        // System.out.println(map);
        
        for (int value : map.values()) {
            if (value % 3 == 0) {
                ans += value/3;
                
            } else if (value % 3 == 2) {
                ans += value/3 + 1;
                
            } else {
                if (value == 1) return -1;
                else {
                    ans += (value - 3)/3 + 2;
                }
            }
            
            // System.out.println(value + " " + ans);
        }
        
        return ans;
    }
}