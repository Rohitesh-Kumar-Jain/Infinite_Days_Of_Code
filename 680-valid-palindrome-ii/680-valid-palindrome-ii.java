class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        
        while(left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++; right--; 
            } else return validSubPalin(s.substring(left + 1, right + 1)) || validSubPalin(s.substring(left, right));
        }
        return true;
    }
    
    public boolean validSubPalin(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++; right--;
        }
        
        return true;
    }
}