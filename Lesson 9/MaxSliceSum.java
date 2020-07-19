import java.util.*;
public class MaxSliceSum {

	public static int solve(int arr[])
	{
		int n = arr.length;
		int mss = 0;
		int msf = Integer.MIN_VALUE;
		for(int i=0; i<n; i++)
		{
			mss += arr[i];
			if(mss < arr[i])
			{
				mss = arr[i];
			}
			msf = Math.max(msf, mss);
		}
		return msf;
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
