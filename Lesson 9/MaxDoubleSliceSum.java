import java.util.*;
public class MaxDoubleSliceSum {

	
	public static int solve(int arr[])
	{
		int n = arr.length;
		int globalMax = Integer.MIN_VALUE;
		int leftPrefix[]  = new int[n];
		int rightSuffix[] = new int[n];
		//forward kadans
		for(int i=1; i<n; i++)
		{
			leftPrefix[i] = Math.max(0,(leftPrefix[i-1]+arr[i]));
		}
		//backward kadans
		for(int i=n-2; i>=0; i--)
		{
			rightSuffix[i] = Math.max(0,(rightSuffix[i+1]+arr[i]));
		}
		for(int i=1; i < n-1; i++)
		{
           globalMax = Math.max(globalMax,(leftPrefix[i-1] + rightSuffix[i+1]));
        } 
		return globalMax;
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
