class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int median = nums[n/2];
        int ans = 0;
        
        for (int i : nums) {
            ans += Math.abs(i - median);
        }
        
        return ans;
    }
}