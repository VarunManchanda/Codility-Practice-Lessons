import java.util.*;
public class MinAvgSliceTwo {

	public static int solve(int arr[])
	{
		int n = arr.length;
		double avg = Double.MAX_VALUE;
		int pos = 0;
		for(int i=0; i<n-2; i++)
		{
			double a = (double)(arr[i]+arr[i+1])/2;
			if(a < avg)
			{
				avg = a;
				pos = i;
			}
			double b = (double)(arr[i]+arr[i+1]+arr[i+2])/3;
			if(b < avg)
			{
				avg = b;
				pos = i;
			}
		}
		double c = (double)(arr[n-2]+arr[n-1])/2;
		if(c < avg)
		{
			avg = c;
			pos = n-2;
		}
		return pos;
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
