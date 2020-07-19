import java.util.*;
public class TieRopes {

	public static int solve(int arr[], int k)
	{
		int ans = 0;
		int l = 0;
		for(int i : arr)
		{
			if(l + i < k) l+=i;
			else
			{
				ans+=1;
				l = 0;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n; n = scan.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) arr[i] = scan.nextInt();
		int k; k = scan.nextInt();
		System.out.println(solve(arr,k));
		scan.close();

	}

}
