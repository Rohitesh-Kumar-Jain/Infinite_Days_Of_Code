// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int at[], int dt[], int n)
    {
        // add your code here
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if (a[0] != b[0]) return a[0] - b[0];
			else {
				return a[1] - b[1];
			}
		});
		
		for (int i : at) pq.add(new int[]{i, 0});
		for (int i : dt) pq.add(new int[]{i, 1});
		int count = 0, ans = 0;
		
		while(pq.size() > 0) {
			int[] cur = pq.poll();
			
			if (cur[1] == 0) {
				count++;
				
			} else {
				count--;
			}
			
			ans = Math.max(ans, count);
		}
		
		return ans;
    }
    
}

