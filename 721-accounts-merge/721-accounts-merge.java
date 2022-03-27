class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, String> email = new HashMap<>();
        DSU dsu = new DSU();
        
        for (List<String> list : accounts) {
            String name = list.get(0);
            String root = list.get(1);
            
            for (int i = 1; i < list.size(); i++) {
                String cur = list.get(i);
                email.put(cur, name);
                dsu.union(root, cur);
            }
        }
        
        // System.out.println(email);
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : email.keySet()) {
            String root = dsu.find(s);
            map.putIfAbsent(root, new ArrayList<String>());
            map.get(root).add(s);
        }
        
        for (String root : map.keySet()) {
            String name = email.get(root);
            List<String> list = map.get(root);
            Collections.sort(list);
            list.add(0, name);
            ans.add(list);
        }
        
        return ans;
    }
    
    class DSU {
        
        Map<String, String> root;
        
        public DSU() {
            root = new HashMap<>();
        }
        
        public String find(String x) {
            if (!root.containsKey(x)) {
                root.put(x, x);
                return x;
            }
            
            if (root.get(x).equals(x)) return x;
            root.put(x, find(root.get(x)));
            
            return root.get(x);
        }
        
        public void union(String x, String y) {
            String rootX = find(x);
            String rootY = find(y);
            
            root.put(rootY, rootX);
        }
    }
}