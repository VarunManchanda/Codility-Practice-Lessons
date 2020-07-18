import java.util.Scanner;

public class TapeEquilibrium {

	public static int solve(int arr[], int n)
	{
		if(n==0 || n==1) return 1;
		int prefix[] = new int[n];
		prefix[0] = arr[0];
		int ans = Integer.MAX_VALUE;
		for(int i=1; i<n; i++) prefix[i] = prefix[i-1]+arr[i];
		for(int p=1; p<n; p++) ans = Math.min(ans,(int)Math.abs(prefix[p-1]-(prefix[n-1]-prefix[p-1])));
		return ans;
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

