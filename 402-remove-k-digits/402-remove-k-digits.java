class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        int i = 0;
        Stack<Character> stack = new Stack<>();
        String ans = "";
        
        while(i < len) {
            while (!stack.empty() && (stack.peek() > num.charAt(i)) && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i++));
        }
        
        while(k-- > 0) stack.pop();
        
        System.out.println(stack);
        
        boolean flag = true;
        for (char ch : stack) {
            if (flag == true && ch == '0') continue;
            flag = false;
            ans = ans + ch;
        }
        
        return ans.equals("") ? "0" : ans;
    }
}