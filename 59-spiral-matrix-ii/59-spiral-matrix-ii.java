class Solution {
    public int[][] generateMatrix(int n) {
        int[][] array= new int[n][n];
        int c= 1;
        int i=0;
        int j=n-1;
        while(c<=n*n){
            for(int k=i;k<=j;k++){
                array[i][k]=c;
                c++;
            }
            for(int l=i+1;l<=j; l++){
                array[l][j]=c;
                c++;
            }
            for(int m=j-1;m>=i;m--){
                array[j][m]=c;
                c++;
            }
            for(int p=j-1;p>i;p--){
                array[p][i]=c;
                c++;
            }
            j--;
            i++;
         }
        return array;
    }
}