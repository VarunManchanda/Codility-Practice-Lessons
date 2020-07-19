import java.util.*;
public class CountNonDivisble {

	public static int[] solve(int arr[])
	{
		int n = arr.length;
		int ans[] = new int[n];
		HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
		for(int i : arr)
		{
			if(hashMap.containsKey(i))
			{
				int v = (int)hashMap.get(i);
				hashMap.put(i,v+1);
			}
			else hashMap.put(i,1);
		}
		int c = 0;
		for(int k=0; k<n; k++)
		{
			c = 0;
			int i = arr[k];
			for(int j=1; j*j<=i; j++)
			{
				if(i%j==0)
				{
					
					c += (hashMap.containsKey(j)) ? hashMap.get(j) : 0;
					if(i/j!=j && hashMap.containsKey(i/j))
					{
						c += hashMap.get(i/j);
					}
				}
			}
			ans[k] = n-c;
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n; n = scan.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) arr[i] = scan.nextInt();
		int ans[] = solve(arr);
		for(int i : ans) System.out.print(i+" ");
		scan.close();
	}

}
