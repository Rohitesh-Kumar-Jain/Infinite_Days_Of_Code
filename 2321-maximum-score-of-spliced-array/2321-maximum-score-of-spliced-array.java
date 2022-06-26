class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pre1 = new int[n + 1];
        int[] pre2 = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            pre1[i] = pre1[i-1] + nums1[i-1];
            pre2[i] = pre2[i-1] + nums2[i-1];
        }
        
        int op1 = getScore(nums1, pre1, pre2);
        int op2 = getScore(nums2, pre2, pre1);
        
        return Math.max(op1, op2);
    }
    
    private int getScore(int[] nums1, int[] pre1, int[] pre2) {
        int n = nums1.length;
        int ans = pre1[n];
        int left = 0;
        
        for (int right = 1; right <= n; right++) {
            int sum1 = pre1[right] - pre1[left];
            int sum2 = pre2[right] - pre2[left];
            
            while(sum1 > sum2 && left <= right) {
                left++;
                sum1 = pre1[right] - pre1[left];
                sum2 = pre2[right] - pre2[left];
            }
            
            ans = Math.max(ans, pre1[n] - sum1 + sum2);
        }
        
        return ans;
    }
}