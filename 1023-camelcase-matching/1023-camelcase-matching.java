class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> list = new ArrayList<>();
        int m = pattern.length();
        
        for (String query : queries) {
            int j = 0, n = query.length();
            boolean flag = true;
            
            for (int i = 0; i < n; i++) {
                char chi = query.charAt(i);
                char chj = '$';
                if (j < m) chj = pattern.charAt(j);
                
                if (chi == chj) {
                    j++;
                    
                } else {
                    if (Character.isUpperCase(chi)) {
                        flag = false;
                        break;
                    }
                    
                }
            }
            
            if (j < m) flag = false;
            
            list.add(flag);
        }
        
        return list;
    }
}