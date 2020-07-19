import java.util.*;
public class ChocolatesByNumber {

	public static int gcd(int a, int b)
	{
		if(a%b==0) return b;
		return gcd(b,a%b);
	}
	public static int solve(int n, int m)
	{
		return n/gcd(n,m);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n,m; n = scan.nextInt(); m = scan.nextInt();
		System.out.println(solve(n,m));
		scan.close();
	}

}
