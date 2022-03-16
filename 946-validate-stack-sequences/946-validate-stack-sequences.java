class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<Integer>();
        int j=0;
        for(int i=0;i<pushed.length;i++){
            s.push(pushed[i]);
            while(s.size() >0 && s.peek()==popped[j]){
                s.pop();
                j++;
            }
        }
        if(s.empty()) return true;
        return false;
    }
}