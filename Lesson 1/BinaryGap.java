import java.util.*;

public class BinaryGap
{
	public static int solve(int n)
	{
		int flag = 0;
		int gaps = 0;
		int ans = Integer.MIN_VALUE;
		while(n>0)
		{
			if((n&1)==1 && flag==0) flag = 1;
			else if((n&1)==0 && flag==1) gaps++;
			else if((n&1)==1 && flag==1) {ans=Integer.max(ans, gaps); gaps = 0;}
			n >>= 1;
		}
		return (ans==Integer.MIN_VALUE) ? 0 : ans;
	}
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int t; t = scan.nextInt();
		while(t-- > 0)
		{
			int n; n = scan.nextInt();
			System.out.println(solve(n));
		}
		scan.close();
	}
	
}
