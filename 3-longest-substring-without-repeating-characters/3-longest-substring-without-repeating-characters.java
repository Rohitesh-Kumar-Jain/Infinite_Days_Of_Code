class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0, j = 0;
        for (char ch : s.toCharArray()) {
            while (set.contains(ch)) set.remove(s.charAt(j++));
            set.add(ch);
            ans = Math.max(ans, set.size());
        }
        return ans;
    }
}