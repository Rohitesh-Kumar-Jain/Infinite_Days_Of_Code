class Solution {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) return nums[0];
        if (n == 1 && k % 2 == 1) return -1;
        
        int max = 0;
        for (int i = 0; i < k - 1 && i < n; i++) {
            max = Math.max(max, nums[i]);
        }
        
        if (k < n) return Math.max(max, nums[k]);
        else if (k == n) return max;
        else {
            return Math.max(max, nums[n - 1]);
        }
    }
}