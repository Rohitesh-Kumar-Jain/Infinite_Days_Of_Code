class Solution {
    public int carFleet(int target, int[] pos, int[] speed) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < speed.length; i++) {
            list.add(new int[]{pos[i], speed[i]});
        }
        Collections.sort(list, (a, b) -> (b[0] - a[0]));
        int ans = 0;
        
        double prev = -1;
        
        for (int i = 0; i < speed.length; i++) {
            double val = (double)(target - list.get(i)[0])/list.get(i)[1];
            
            if (prev < val) {
                prev = val; ans++;
            }
        }
        
        return ans;
    }
}