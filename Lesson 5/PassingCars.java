import java.util.*;
public class PassingCars {

	public static int solve(int arr[])
	{
		int countZeroes = 0, count = 0;
		for(int i : arr)
		{
			if(i==0) ++countZeroes;
			else count+=countZeroes;
		}
		return (count > 1000000000) ? -1 : count;
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
