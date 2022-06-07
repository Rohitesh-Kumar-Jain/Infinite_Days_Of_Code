class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        m--; n--;
        
        while(k >= 0) {
            int op1 = m >= 0 ? nums1[m] : Integer.MIN_VALUE;
            int op2 = n >= 0 ? nums2[n] : Integer.MIN_VALUE;
            
            if (op1 > op2) {
                nums1[k] = op1; m--;
                
            } else {
                nums1[k] = op2; n--;
            }
            
            k--;
        }
    }
}