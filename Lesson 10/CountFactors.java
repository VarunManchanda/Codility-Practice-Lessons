import java.util.*;
public class CountFactors {
	public static int solve(int n)
	{
		long ans = 0;
		for(long i=1; i*i<=n; i++) { if(n%i==0) {if(i*i==n) ans+=1; else ans+=2;} }
		return (int)ans;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n; n = scan.nextInt();
		System.out.println(solve(n));
		scan.close();
		int a = 3;
		int b = 12;
		int c = a%b;
		System.out.println("C is"+c);
	}

}
