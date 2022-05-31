class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] ple = new int[n];
        int[] nle = new int[n];
        int maxArea = 0;
        
        Stack<Integer> stack_nle = new Stack<>();
        Stack<Integer> stack_ple = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while(!stack_ple.empty() && heights[stack_ple.peek()] > heights[i]) {
                stack_ple.pop();
            }
            
            ple[i] = stack_ple.empty() ? i+1 : i - stack_ple.peek();
            stack_ple.push(i);
        }
        
        for (int i = 0; i < n; i++) {
            nle[i] = n - i;
        }
        
        for (int i = 0; i < n; i++) {
            while(!stack_nle.empty() && heights[stack_nle.peek()] > heights[i]) {
                int j = stack_nle.pop();
                nle[j] = i - j;
            }
            stack_nle.push(i);
        }
        
        for (int i = 0; i < n; i++) {
            int area = heights[i] * (nle[i] + ple[i] - 1);
            maxArea = Math.max(area, maxArea);
        }
        
        return maxArea;
    }
}