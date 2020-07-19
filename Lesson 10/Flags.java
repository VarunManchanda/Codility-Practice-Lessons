import java.time.Duration;
import java.time.Instant;
import java.util.*;
public class Flags {

	public static boolean check(List<Integer> arr, int mid, int k)
	{	
		int n = arr.size();
		int used = 1;
		int s = 0;
		if(n>=1)s=arr.get(0);															
		for(int i=1; i<n; i++)
		{
			if((int)Math.abs(arr.get(i)-s) >= mid)	
			{
				System.out.println("Flagging on->"+arr.get(i));
				used++;
				s = arr.get(i);
			}
		}
		if(used>=mid) return true;	
		System.out.println("Failing for->"+mid);
		return false;
	}
	public static int solve(int arr[])
	{
		int flags = 0;
		int n = arr.length;
		if(n<=2)return 0;
		List<Integer> flagArr = new ArrayList<Integer>();
//		for(int p=1; p<n-1; p++)
//		{
//			if(arr[p-1]<arr[p] && arr[p]>arr[p+1]) flagArr.add(p);
//		}
		flagArr.add(6);
		flagArr.add(10);
		flagArr.add(14);
		flagArr.add(16);
		flagArr.add(20);
		int k = flagArr.size();
		int s = 0;
		int e = flagArr.size();
		while(s<=e)
		{
			int mid = s + (e-s)/2;
			if(check(flagArr,mid,k)==true) {flags = mid; s=mid+1;}
			else e=mid-1;																													// changed
		}	
		return flags;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n; n = scan.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) arr[i] = scan.nextInt();
		Instant start = Instant.now();
		System.out.println(solve(arr));	
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
		scan.close();
	}
	
}
