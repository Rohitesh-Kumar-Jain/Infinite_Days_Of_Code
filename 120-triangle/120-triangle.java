class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            int k = list.size();
            
            for (int j = 0; j < k; j++) {
                int val = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                list.set(j, list.get(j) + val);
            }
        }
        
        return triangle.get(0).get(0);
    }
}