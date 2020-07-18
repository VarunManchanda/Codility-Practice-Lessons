import java.util.*;
public class MaxProductOfThree {

	public static int solve(int arr[])
	{
		int n = arr.length;
		Arrays.sort(arr);
		int a = arr[0]*arr[1]*arr[n-1];
		int b = arr[n-3]*arr[n-2]*arr[n-1];
		return Integer.max(a,b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n; n = scan.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) arr[i] = scan.nextInt();
		System.out.println(Test.solve1(arr));
		scan.close();
	}

}
