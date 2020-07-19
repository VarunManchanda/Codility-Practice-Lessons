import java.time.Duration;
import java.time.Instant;
import java.util.*;
class pair
{
	public int first,second;
	public pair(int a, int b)
	{
		this.first=a;
		this.second=b;
	}
}
public class FibFrog {

	public static int bfs(int arr[])
	{
		int n = arr.length;
		int pos = -1;
		List<Integer> jumps = new ArrayList<Integer>();
		List<Integer> fibs =  new ArrayList<Integer>();
		HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> visited = new HashMap<Integer,Integer>();
		jumps.add(-1); hashMap.put(-1,0);
		for(int i=0; i<n; i++) {if(arr[i]==1) {jumps.add(i); hashMap.put(i,jumps.size()-1);}}
		jumps.add(n); hashMap.put(n,jumps.size()-1);
		int a = 0;
		int b = 1;
		fibs.add(a); fibs.add(b);
		while(fibs.get(fibs.size()-1) < (n+1))
		{
			int c = a+b;
			a = b;
			b = c;
			fibs.add(c);
		}
		Queue<pair> q = new LinkedList<pair>();
		visited.put(-1,1);
		q.add(new pair(-1,-1));
		while(!q.isEmpty())
		{
			boolean flag = false;
			pair node = q.peek(); q.remove();
			if(node.first==n) return node.second+1;
			for(int i=fibs.size()-1; i>=0; i--)
			{
				int step = fibs.get(i) + node.first;
				if(step!=pos && !visited.containsKey(step) && hashMap.containsKey(step)==true)
				{
					flag = true;
					visited.put(step,1);
					q.add(new pair(step,node.second+1));
				}
				if(!flag) break;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n; n = scan.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) arr[i] = scan.nextInt();
		Instant start = Instant.now();
		System.out.println(bfs(arr));
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		System.out.println("Time taken by BFS: "+ timeElapsed.toSeconds() +" seconds");
		scan.close();
	}

}
