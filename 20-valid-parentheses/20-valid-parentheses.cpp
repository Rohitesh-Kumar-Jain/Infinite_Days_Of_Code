class Solution {
public:
    bool isValid(string s) {
        int n= s.length();
        stack<char> valid;
        for(int i=0;i<n;i++){
            if(valid.empty()){
                valid.push(s[i]);
            }
            else{
                if(s[i]==')'){
                    if(valid.top()=='(') valid.pop();
                    else return false;
                }
                else if(s[i]=='}'){
                    if(valid.top()=='{') valid.pop();
                    else return false;
                }
                else if(s[i]==']'){
                    if(valid.top()=='[') valid.pop();
                    else return false;
                }
                else valid.push(s[i]);
            }
        }
        return valid.empty();
    }
};