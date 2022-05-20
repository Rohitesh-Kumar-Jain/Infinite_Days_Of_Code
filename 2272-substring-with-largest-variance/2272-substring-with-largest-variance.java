class Solution {
    public int largestVariance(String s) {
        
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            if (set.size() == 26) break;
        }
        
        for (char ch1 = 'a'; ch1 <= 'z'; ch1++) {
            for (char ch2 = 'a'; ch2 <= 'z'; ch2++) {
                if (ch1 == ch2 || !set.contains(ch1) || !set.contains(ch2)) continue;
                int n = s.length();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    char ch = s.charAt(i);
                    if (ch == ch1) arr[i] = 1;
                    else if (ch == ch2) arr[i] = -1;
                }
                
                int meh1 = 0, meh2 = 0;
                int msf = 0;
                
                boolean flag1 = false, flag2 = false;
                
                for (int i : arr) {
                    
                    if (i == 0) continue;
                    
                    meh1 = meh1 + i;
                    meh2 = meh2 + i;
                    
                    if (i == -1) { flag1 = true; flag2 = true;}
                    
                    if (i > meh1 && i == -1) meh1 = i;
                    
                    if (i > meh2) {
                        if (i == 1) flag2 = false;
                        meh2 = i;
                    }
                    
                    if (meh1 > msf && flag1 == true) {
                        msf = meh1;
                    }
                    
                    if (meh2 > msf && flag2 == true) {
                        msf = meh2;
                    }
                }
                
                max = Math.max(max, msf);
                // System.out.println(meh1 + " " + meh2 + " " + msf + " " + Arrays.toString(arr));
            }
        }
        
        return max;
    }
}