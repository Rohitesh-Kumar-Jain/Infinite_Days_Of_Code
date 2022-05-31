class StockSpanner {
    
    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int time = 0;
        while(!stack.empty() && stack.peek()[0] <= price) {
            time += stack.pop()[1];
        }
        stack.push(new int[]{price, time + 1});
        return time + 1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */