class Solution {
    public int minOperations(int[] nums, int x) {
        int left = 0;
        int ans = 0, sum = 0;
        for (int i : nums) sum += i;
        if (sum == x) return nums.length;
        x = sum - x;
        
        for (int right = 0; right < nums.length; right++) {
            x = x - nums[right];
            while(x < 0 && left < nums.length) { x += nums[left++];}
            if (x == 0) ans = Math.max(ans, right - left + 1);
        }
        
        return ans != 0 ? nums.length - ans : - 1;
    }
}