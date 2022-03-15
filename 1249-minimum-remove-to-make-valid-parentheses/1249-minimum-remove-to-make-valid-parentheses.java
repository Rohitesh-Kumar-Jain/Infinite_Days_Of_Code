class Solution {
    public String minRemoveToMakeValid(String string) {
        Stack<Pair<Character, Integer>> s = new Stack<>();
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            
            if (ch == '(') {
                s.push(new Pair(ch, i));
                
            } else if (ch == ')') {
                if (s.size() > 0 && s.peek().getKey() == '(') s.pop();
                else s.push(new Pair(ch, i));
            }
        }
        
        while(s.size() > 0) {
            set.add(s.pop().getValue());
        }
        
        for (int i = 0; i < string.length(); i++) {
            if (!set.contains(i)) sb.append(string.charAt(i));
        }
        
        return sb.toString();
    }
}