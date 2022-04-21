class Solution {
    public String countOfAtoms(String formula) {
        
        Map<String, Integer> map = helper(0, formula);
        List<String> list = new ArrayList<>();
        String ans = "";
        
        for (String key : map.keySet()) list.add(key);
        Collections.sort(list, (a, b) -> a.compareTo(b));
        
        for (String s : list) {
            if (map.get(s) != 1) {
                ans += s + map.get(s);
                
            } else ans += s;
        }
        
        // System.out.println(map);
        
        return ans;
    }
    
    private Map<String, Integer> helper(int i, String s) {
        Map<String, Integer> map = new HashMap<>();
        System.out.println(s + " " + s.charAt(i));
        
        while(i < s.length()) {
            
            if (s.charAt(i) == '(') {
                String st = ""; i++;
                int count = 1;
                while(i < s.length() && count > 0) {
                    if (s.charAt(i) == ')') count--;
                    else if (s.charAt(i) == '(') count++;
                    if (count == 0) break;
                    st += s.charAt(i++);
                }
                Map<String, Integer> sub = helper(0, st);
                i++;
                int mul = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    mul = mul*10 + (s.charAt(i++) - '0');
                }
                
                if (mul == 0) mul = 1;
                
                for (String key : sub.keySet()) {
                    map.put(key, map.getOrDefault(key, 0) + sub.get(key) * mul);
                }
                
            } else {
                String st = "" + s.charAt(i++);
                while(i < s.length() && Character.isLowerCase(s.charAt(i))) st += s.charAt(i++);
                int mul = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) mul = mul*10 + (s.charAt(i++) - '0');
                if (mul == 0) mul = 1;
                map.put(st, map.getOrDefault(st, 0) + mul);
            }
            
            // System.out.print(map + " : ");
            // if (i < s.length()) System.out.print(s.charAt(i));
            // System.out.println();
        }
        
        return map;
    }
}