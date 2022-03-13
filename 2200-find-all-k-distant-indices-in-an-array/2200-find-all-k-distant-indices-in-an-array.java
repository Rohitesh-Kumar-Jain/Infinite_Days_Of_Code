class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        
        List<Integer> keyList = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == key) keyList.add(i);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j : keyList) {
                if (Math.abs(i - j) <= k) {
                    ans.add(i);
                    break;
                }
            }
        }
        
        return ans;
    }
}