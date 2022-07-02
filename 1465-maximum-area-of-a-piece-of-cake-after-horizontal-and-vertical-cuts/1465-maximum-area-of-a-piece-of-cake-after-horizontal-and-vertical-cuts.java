class Solution {
    public int maxArea(int h, int w, int[] hCuts, int[] vCuts) {
        int d = 1_000_000_007;
        Arrays.sort(hCuts);
        Arrays.sort(vCuts);
        
        long maxh = 1, maxw = 1;
        int prev = 0;
        
        for (int cur : hCuts) {
            maxh = Math.max(maxh, cur - prev);
            prev = cur;
        }
        maxh = Math.max(maxh, h - prev);
        
        prev = 0;
        
        for (int cur : vCuts) {
            maxw = Math.max(maxw, cur - prev);
            prev = cur;
        }
        maxw = Math.max(maxw, w - prev);
        maxh = maxh%d; maxw = maxw%d;
        
        long ans = maxh * maxw;
        ans %= d;
        
        return (int) ans;
    }
}