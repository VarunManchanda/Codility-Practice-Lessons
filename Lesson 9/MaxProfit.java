import java.util.*;
public class MaxProfit {
	
	public static int solve(int arr[])
	{
		//time->  O(N)
		//space-> O(N)
		int n = arr.length;
		if(n==0) return 0;
		int ans = (int)-1e9;
		int pastMax[] = new int[n];
		pastMax[n-1] = arr[n-1];
		for(int i=0; i<n-1; i++) //this loop will find max from right side
		{
			pastMax[n-i-2] = Integer.max(pastMax[n-i-1],arr[n-i-2]);
		}
		for(int i=0; i<n; i++) //now just find the maximum difference
		{
			ans = Integer.max(ans,pastMax[i]-arr[i]);
		}
		return ans;
		//Example:-                      3  5  13  1  2 10
		//my max from right array is:-   13 13 13 10 10 10
		//and difference is:-            10 8  0  9  8  0 so maximum out of these is 10 :P
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n; n = scan.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) arr[i] = scan.nextInt();
		System.out.println(solve(arr));
		scan.close();

	}
}
