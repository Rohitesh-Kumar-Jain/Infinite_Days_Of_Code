class Solution {
    public List<Integer> partitionLabels(String s) {
        List<int[]> mergedIntervals = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Map<Character, int[]> interval = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (interval.containsKey(ch)) {
                interval.get(ch)[1] = i;
            } else {
                interval.put(ch, new int[] {i, i});
            }
        }
        for (char ch : interval.keySet()) {
            list.add(interval.get(ch));
        }
        
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        
        // for (int [] a : list) System.out.println(Arrays.toString(a));
        
        for (int [] arr : list) {
            int n = mergedIntervals.size();
            if (n == 0) {
                mergedIntervals.add(arr);
                
            } else if (mergedIntervals.get(n - 1)[1] >= arr[0]) {
                mergedIntervals.get(n-1)[1] = Math.max(mergedIntervals.get(n-1)[1], arr[1]);
                
            } else {
                mergedIntervals.add(arr);
            }
        }
        for (int [] arr : mergedIntervals) {
            ans.add(arr[1] - arr[0] + 1);
        }
        return ans;
    }
}