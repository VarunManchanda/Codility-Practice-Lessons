import java.util.*;
public class Triangle {

	public static int solve(int arr[])
	{
		Arrays.sort(arr);
		int n = arr.length;
		if(n<3) return 0;
		for(int i=0; i<n-2; i++)
		{
		    long a = arr[i];
		    long b = arr[i+1];
		    long c = arr[i+2];
			if((a+b)>c) return 1;
		}
		return 0;
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
