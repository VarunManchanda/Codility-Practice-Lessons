import java.util.*;
public class MaxProductOfThree {

	public static int solve(int arr[])
	{
		HashSet<Integer> s = new HashSet<Integer>();
		for (int i=1; i<5; i++) s.add(1);
		return s.size();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n; n = scan.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) arr[i] = scan.nextInt();
		System.out.println(solve(arr));
		scan.close();
	}

}
