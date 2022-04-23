class Solution {
    public String digitSum(String s, int k) {
        
        while(s.length() > k) {
            String t = "";
            int num = 0;
            for (int i = 0; i < s.length(); i++) {
                if (i % k == 0 && i != 0) {
                    t = t + num;
                    num = s.charAt(i) - '0';
                    
                } else {
                    num += s.charAt(i) - '0';
                }
            }
            t = t + num;
            // System.out.println(t);
            s = t;
        }
        
        return s;
    }
}