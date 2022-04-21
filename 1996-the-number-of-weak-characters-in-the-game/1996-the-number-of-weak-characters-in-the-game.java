class Solution {
    public int numberOfWeakCharacters(int[][] prop) {
        int n = prop.length;
        Arrays.sort(prop, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
                
            } else {
                return b[1] - a[1];
            }
        });
        
        int ans = 0;
        
        int mx = prop[0][0], my = prop[0][1];
        
        int i = 0;
        while(i < n && mx == prop[i][0]) i++;
        
        if (i >= n ) return 0;
        
        int cur = prop[i][0];
        int curYmax = prop[i][1];
        
        while(i < n) {
            if (prop[i][0] == cur) {
                if (my > prop[i][1]) ans++;
                i++;
                
            } else {
                my = Math.max(my, curYmax);
                curYmax = prop[i][1];
                cur = prop[i][0];
            }
        }
        
        return ans;
    }
}