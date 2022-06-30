class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        
        if (bloomDay.length < m*k) return -1;

        for (int b : bloomDay) {
            low = Math.min(low, b);
            high = Math.max(high, b);
        }

        while(low < high) {
            int mid = low + (high - low)/2;

            if (satisfies(mid, bloomDay, k, m) == true) {
                high = mid;

            } else {
                low = mid + 1;
            }
        }
        
        return high;
    }
    
    public boolean satisfies(int x, int[] bloomDay, int k, int m) {
        int count = 0;
        int cur = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= x) {
                cur++;
            } else {
                cur = 0;
            }

            if (cur == k) {
                count++;
                cur = 0;
            }
        }
        
        // System.out.println(x + " " + count);

        return count >= m;
    }
}