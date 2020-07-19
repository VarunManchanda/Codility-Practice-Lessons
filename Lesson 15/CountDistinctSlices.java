import java.util.*;
public class CountDistinctSlices {

	public static int solve(int arr[])
	{
		int ans = 0;
		int n = arr.length;
		Deque<Integer> dq = new LinkedList<Integer>();
		HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
		int c = 0;
		for(int i=0; i<n; i++)
		{
			if(hashMap.containsKey(arr[i])==false)
			{
				System.out.println("debugger "+" pushing->"+arr[i]);
				dq.add(arr[i]);
				hashMap.put(arr[i],1);
				c += dq.size();
			}
			else
			{
				while(!dq.isEmpty() && hashMap.containsKey(arr[i]))
				{
					System.out.println("debugger "+" popping->"+dq.peekFirst());
					int f = dq.peekFirst();
					if(f==arr[i])
					{
						hashMap.remove(arr[i]);
						dq.removeFirst();
						break;
					}
					dq.removeFirst();
					if(hashMap.containsKey(f)) hashMap.remove(f);
				}
				dq.add(arr[i]);
				hashMap.put(arr[i],1);
				c += dq.size();
			}
			
		}
		return c;
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
