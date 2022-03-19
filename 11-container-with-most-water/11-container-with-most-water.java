class Solution {
    public int maxArea(int[] h) {
        int left = 0;
        int ans = 0;
        int right = h.length - 1;
        
        while(left < right) {
            ans = Math.max(ans, (right - left) * Math.min(h[left], h[right]));
            
            if (h[left] < h[right]) left++;
            else right--;
        }
        
        return ans;
    }
}