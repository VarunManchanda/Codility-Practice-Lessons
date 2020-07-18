import java.util.Scanner;

public class CyclicRotation {
	
	public static void solve(int arr[], int n, int k)
	{
		if(n==0 || k==n) return;
		while(k-- > 0)
		{
			int last = arr[n-1];
			arr[n-1] = 0;
			for(int i=0; i<n-1; i++) arr[n-i-1] = arr[n-i-2];
			arr[0] = last;
		}
		return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) arr[i] = scan.nextInt();
		solve(arr,n,k);
		for(int i : arr) System.out.print(i+" ");
		scan.close();
	}

}
