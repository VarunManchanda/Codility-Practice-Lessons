import java.util.*;
public class NumberSolitare {

	public static final int N = (int)10e5;
	public static int solve(int arr[])
	{
		 int[] dp = new int[N];
		 //dp[i] represents maximum sum upto 'i'
		 //so for dp[5] = max(dp[5-k]+arr[5]) where k is [1,6]
	       dp[0] = arr[0];
	       int n = arr.length;
	       for(int i=1; i<n; i++)
	       {
	            int max = (int)-1e9;
	            for(int k=1; k<=6; k++)
	            {
	                if(i-k>=0)
	                {
	                    max = Math.max((dp[i-k]+arr[i]),max);
	                }
	            }    
	            dp[i] = max;  
	        }
	        return dp[n-1];
	}
	public static void main(String[] arrrgs) {
		Scanner scan = new Scanner(System.in);
		int n; n = scan.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) arr[i] = scan.nextInt();
		System.out.println(solve(arr));
		scan.close();
	}

}
