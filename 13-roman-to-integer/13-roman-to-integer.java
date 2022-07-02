class Solution {
    public int romanToInt(String s) {
        int ans=0;
        Map<Character, Integer> map = Stream.of(new Object[][] { 
            {'I',1}, {'V',5}, {'X',10}, {'L',50}, {'C',100}, {'D',500}, {'M',1000}, 
        }).collect(Collectors.toMap(data -> (Character) data[0], data -> (Integer) data[1]));
        
        for(int i=0;i<s.length()-1;i++){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))) ans -= map.get(s.charAt(i));
            else ans += map.get(s.charAt(i));
        }
        return ans + map.get(s.charAt(s.length()-1));
    }
}