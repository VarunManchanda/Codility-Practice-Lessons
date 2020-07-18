import java.util.Scanner;

public class OddOccurrencesInArray {

	public static int solve(int arr[], int n)
	{
		long s = 0;
		for(int i : arr) s^=i;
		return (int)s;
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
