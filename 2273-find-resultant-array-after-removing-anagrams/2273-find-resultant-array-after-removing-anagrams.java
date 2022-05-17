class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> noAnagrams = new ArrayList<>();
        int[] prevFreq = new int[26];
        
        for (String word : words) {
            int[] curFreq = new int[26];
            for (char ch : word.toCharArray()) {
                curFreq[ch - 'a']++;
            }
            
            boolean isAnagram = true;
            
            for (int i = 0; i < 26; i++) {
                if (prevFreq[i] != curFreq[i]) {
                    isAnagram = false;
                    break;
                }
            }
            
            if (isAnagram == false) noAnagrams.add(word);
            prevFreq = curFreq;
        }
        
        return noAnagrams;
    }
}