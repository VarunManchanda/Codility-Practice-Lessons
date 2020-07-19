import java.util.*;
public class AbsDistinct {

	public static int solve(int arr[])
	{
		HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
		for(int i : arr)
		{
			if(hashMap.containsKey(Math.abs(i))==false) hashMap.put(Math.abs(i),1);
		}
		return hashMap.size();
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
