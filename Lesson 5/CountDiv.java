import java.util.*;
public class CountDiv {
	public static int solve(int A, int B, int k)
	{
		
		/*
		 * <-------------------c------->|
		 * |---------------A-----------B|
		 * <-------------->|<---(c-d)-->|
		 *       d
		 */
		int c = B/k - 0;
		int d = A/k - 0;
		int ans = c-d;
		return (A%k==0) ? ans+1 : ans;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a,b,k;
		a = scan.nextInt();
		b = scan.nextInt();
		k = scan.nextInt();
		System.out.println(solve(a,b,k));
		scan.close();

	}

}
