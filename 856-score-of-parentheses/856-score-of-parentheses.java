class Solution {
    public int scoreOfParentheses(String st) {
        
        Stack<String> s = new Stack<>();
        
        for (char ch : st.toCharArray()) {
            // System.out.println(s);
            if (ch == ')') {
                if (s.peek().equals("(")) {
                    s.pop();
                    int val = 0;
                    if (s.size() > 0 && Character.isDigit(s.peek().charAt(0)) == true) {
                        val = Integer.parseInt(s.pop());
                    }
                    val++;
                    s.push(Integer.toString(val));
                    
                } else {
                    int val = Integer.parseInt(s.pop());
                    s.pop(); val = val * 2;
                    while(s.size() > 0 && Character.isDigit(s.peek().charAt(0)) == true) {
                        val = val + Integer.parseInt(s.pop());
                    }
                    String newVal = Integer.toString(val);
                    s.push(newVal);
                }
                
            } else {
                s.push(Character.toString(ch));
            }
        }
        
        
        // System.out.println(s);
        
        return Integer.parseInt(s.pop());
    }
}