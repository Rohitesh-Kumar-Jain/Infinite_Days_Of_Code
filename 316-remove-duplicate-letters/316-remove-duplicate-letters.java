class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> lastOccur = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            lastOccur.put(ch, i);
        }
        
        Stack<Character> stack = new Stack<>();
        Set<Character> present = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            while(!stack.empty() && stack.peek() > ch && lastOccur.get(stack.peek()) > i && !present.contains(ch)) {
                char prev = stack.pop();
                present.remove(prev);
            }
            if (!present.contains(ch)) {
                stack.push(ch);
                present.add(ch);
            }
        }
        
        String ans = "";
        
        while(stack.size() > 0) {
            ans = stack.pop() + ans;
        }
        
        return ans;
    }
}