class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        Map<Character, Set<Character>> map = new HashMap<>();
        int slen = s.length(), sublen = sub.length();
        
        for (char[] mapping : mappings) {
            map.putIfAbsent(mapping[0], new HashSet<>());
            map.get(mapping[0]).add(mapping[1]);
        }
        
        for (int i = 0; i < slen; i++) {
            int j = i;
            int len = 0, k = 0;
            while(j < slen && k < sublen && ((s.charAt(j) == sub.charAt(k)) || (map.get(sub.charAt(k)) != null && map.get(sub.charAt(k)).contains(s.charAt(j))))) {
                j++; k++;
                len++;
            }
            if (len == sublen) {
                return true;
            }
        }
        
        return false;
    }
}