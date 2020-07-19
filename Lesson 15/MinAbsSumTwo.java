import java.util.*;
public class MinAbsSumTwo {

	public static int solveBF(int arr[])
	{
		int n = arr.length;
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				ans = Math.min(ans,Math.abs(arr[i]+arr[j]));
			}
		}	
		return ans;
	}
	public static int solveFA(int arr[])
	{
		int ans = Integer.MAX_VALUE;
		List<Integer> positives = new ArrayList<Integer>();
		List<Integer> negatives = new ArrayList<Integer>();
		List<Integer> finalSorted = new ArrayList<Integer>();
		for(int i : arr) 
		{
			if(i>0) positives.add(i); 
			else negatives.add(i);
		}
		Collections.sort(positives); Collections.sort(negatives);
		for(int i : positives) finalSorted.add(i);
		for(int i : negatives) finalSorted.add(i);
		int p = 0;
		int q = finalSorted.size()-1;
		while(p<=q)
		{
			if(Math.abs(finalSorted.get(p)+finalSorted.get(q)) < ans)
			{
				ans = Math.abs(finalSorted.get(p)+finalSorted.get(q));
				p+=1;
			}
			else q-=1;
		}
		return ans;
	}
	public static int solveNL(int arr[])
	{
		int ans = Integer.MAX_VALUE;
		Arrays.sort(arr);
		int p = 0;
		int q = arr.length-1;
		while(p<=q)
		{
			ans = Math.min(ans, Math.abs(arr[p]+arr[q]));
			if(Math.abs(arr[p]) > Math.abs(arr[q])) p+=1;
			else q-=1;
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n; n = scan.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) arr[i] = scan.nextInt();
		System.out.println(solveNL(arr));
		scan.close();
	}

}
