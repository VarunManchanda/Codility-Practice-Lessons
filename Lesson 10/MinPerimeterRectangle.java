import java.util.*;
public class MinPerimeterRectangle {

	public static int solve(int n)
	{
		int perimeter = (int)1e18;
		for(int i=1; i*i<=n; i++)
		{
			if(n%i==0)
			{
				int a = i;
				int b = n/i;
				perimeter = Math.min(perimeter, (2*(a+b)));
			}
		}
		return perimeter;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n; n = scan.nextInt();
		System.out.println(solve(n));
		scan.close();
	}

}
