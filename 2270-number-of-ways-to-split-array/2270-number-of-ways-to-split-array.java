class Solution {
    public int waysToSplitArray(int[] nums) {
        long rsum = 0, lsum = 0;
        int ways = 0;
        
        for (int num : nums) rsum += num;
        
        for (int i = 0; i < nums.length - 1; i++) {
            lsum += nums[i];
            rsum -= nums[i];
            if (lsum >= rsum) ways++;
        }
        
        return ways;
    }
}