import java.util.*;
public class EquiLeader {
	
	public static int findLeader(int arr[])
	{
		HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
		int n = arr.length;
		int m = n/2;
		for(int i : arr)
		{
			if(hashMap.containsKey(i))
			{
				int v = (int)hashMap.get(i);
				hashMap.put(i,v+1);
			}
			else hashMap.put(i,1);
		}
		for(int i=0; i<n; i++)
		{
			int v = (int)hashMap.get(arr[i]);
			if(v > m) return arr[i];
		}
		return -1;
	}

	public static int solve(int arr[])
	{
		int n = arr.length;
		int ans = 0;
		int leader = findLeader(arr);
		if(leader==-1) return 0;
		List<Integer> prefix = new ArrayList<Integer>();
		prefix.add(0);
		for(int i=0; i<n; i++) 
		{
			if(arr[i]==leader) prefix.add(prefix.get(prefix.size()-1)+1);
			else prefix.add(prefix.get(prefix.size()-1)+0);
		}
		prefix.remove(0);
		int m = prefix.size();
		int c = m-1;
		for(int i=0; i<m; i++)
		{
			if((prefix.get(i) > (i+1)/2) && (prefix.get(c)-prefix.get(i) > (c-i)/2)) ans++;
		}
		return ans;
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
