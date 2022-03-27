class Solution {
public:
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
        vector<int> ans;
        multimap<int,int> hashmap;
        for(int i=0;i<mat.size();i++){
            int count=0;
            int j=0;
            while(j<mat[i].size() && mat[i][j]==1){
                count++;
                j++;
            }
            hashmap.insert(pair <int, int> (count,i));
        }
        for(auto it: hashmap){
            if(k<=0) break;
            ans.push_back(it.second);
            k--;
        }
        return ans;
    }
};