class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int ans = 0;
        Set<Integer> no = new HashSet<>();
        for (int i : forbidden) no.add(i);
        Queue<int[]> bfs = new LinkedList<>();
        bfs.add(new int[]{0 , 0});
        
        while(bfs.size() > 0) {
            int k = bfs.size();
            
            for (int t = 0; t < k; t++) {
                int[] arr = bfs.poll();
                int cur = arr[0], backs = arr[1];
                
                if (no.contains(cur) || cur < 0 || cur > 6000) continue;
                if (cur == x) return ans;
                no.add(cur);
                
                if (backs == 0) bfs.add(new int[]{cur - b, 1});
                bfs.add(new int[]{cur + a, 0});
            }
            
            ans++;
        } 
        
        return -1;
    }
}