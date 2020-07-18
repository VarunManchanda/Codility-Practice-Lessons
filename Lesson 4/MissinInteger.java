import java.util.Arrays;
import java.util.Scanner;
public class MissinInteger {
	public static int find(int arr[], int n, int key)
	{
		int s = 0;
		int e = n-1;
		while(s<=e)
		{
			int mid = s + (e-s)/2;
			if(arr[mid]==key) return mid;
			else if(arr[mid]<key) s = mid+1;
			else e = mid-1;
		}
		return -1;
	}
	public static int solve(int arr[], int n)
	{
		Arrays.sort(arr); //sort the array first
		int count[] = new int[n+1];
		int sum = 0;
		for(int i=1; i<=n; i++)
		{
			if(find(arr,n,i)==-1) return i;  //now search the element is present or not
			if(count[i]==0) count[i] = 1;
		}
		for(int i=1; i<=n; i++) sum += count[i];
		if(sum==n) return n+1;
		return 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) arr[i] = scan.nextInt();
		System.out.println(solve(arr,n));
		scan.close();
	}

}
