class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long[] prefix = new long[n+1];
        long ans = 0;
        
        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] + nums[i];
        }
        
        int j = 0;
        
        for (int i = 0; i < n; i++) {
            long sum = prefix[i+1] - prefix[j];
            long length = i - j + 1;
            
            while(sum * length >= k) {
                j++;
                sum = prefix[i+1] - prefix[j];
                length = i - j + 1;
            }
            
            ans += i - j + 1;;
        }
        
        return ans;
    }
}