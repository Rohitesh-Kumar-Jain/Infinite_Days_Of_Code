class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int ans = 0;
        int local = 0;
        int j = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            while (set.contains(nums[i]) && j < i) {
                set.remove(nums[j]);
                local -= nums[j++];
            }
            local += nums[i];
            set.add(nums[i]);
            ans = Math.max(local, ans);
        }
        return ans;
    }
}