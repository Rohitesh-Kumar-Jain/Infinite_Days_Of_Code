class Solution {
    public int countLatticePoints(int[][] circles) {
        Set<String> set = new HashSet<>();
        
        for (int[] circle : circles) {
            int x = circle[0], y = circle[1], r = circle[2];
            
            for (int i = -r; i <= r; i++) {
                for (int j = -r; j <= r; j++) {
                    
                    if ((i * i) + (j * j) <= r * r) {
                        set.add((x + i) + ":" + (y + j));
                    }
                }
            }
        }
        
        // System.out.println(set);
        
        return set.size();
    }
}