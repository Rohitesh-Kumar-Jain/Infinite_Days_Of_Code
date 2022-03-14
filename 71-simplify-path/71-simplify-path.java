class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        
        // System.out.println(Arrays.toString(paths));
        
        for (String dir : paths) {
            if (dir.equals(".") || dir.equals("")) continue;
            else if (dir.equals("..")) {
                if (stack.size() > 0) stack.pop();
            } else {
                stack.push(dir);
            }
        }
        
        String ans = "";
        
        while(stack.size() > 0) {
            ans = "/" + stack.pop() + ans;
        }
        
        return ans.length() == 0 ? "/" : ans;
    }
}