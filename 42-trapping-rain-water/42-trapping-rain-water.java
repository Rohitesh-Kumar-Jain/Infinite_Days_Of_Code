class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n-1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;
        
        while(left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            
            if (height[left] <= height[right]) {
                ans += Math.min(leftMax, rightMax) - height[left];
                left++;
                
            } else {
                ans += Math.min(leftMax, rightMax) - height[right];
                right--;
            }
        }
        
        return ans;
    }
}