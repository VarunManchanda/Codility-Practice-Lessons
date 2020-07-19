import java.util.*;
public class MinMaxDivision {

	public static boolean check(int a[], int mid, int k)
	{
		int sum = 0;
		int n = a.length;
		int used = 1;
		for(int i=0; i<n; i++)
		{
        	if(a[i]>mid) return false; //because no use of adding this value as it will always give largest value than mid
			sum += a[i];
			if(sum > mid)
			{
				sum = a[i];
				used+=1;
			}
		}
		return used<=k;
	}
	public static int solve(int arr[], int k, int m)
	{
		int s = 0;
		int e = 0;
		int ans = -1;
		for(int i : arr) e+=i;
		while(s<=e)
		{
			int mid=s+(e-s)/2;
			if(check(arr,mid,k))
			{
				ans = mid; 
				e = mid-1;
			}
			else s = mid+1;
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n; n = scan.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) arr[i] = scan.nextInt();
		int k; k = scan.nextInt();
		int m; m = scan.nextInt();
		System.out.println(solve(arr,k,m));
		scan.close();
	}

}
