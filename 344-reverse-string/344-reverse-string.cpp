class Solution {
public:
    void recurse(vector<char>& s,int left,int right){
        if(left>right) return;
        char temp= s[left];
        s[left]=s[right];
        s[right]=temp;
        recurse(s,left+1,right-1);
    }
    
    void reverseString(vector<char>& s) {
        recurse(s,0,s.size()-1);
    }
};