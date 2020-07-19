import java.util.*;
public class MaxNonOverlappingSegments {

	public static int solve(int a[], int b[])
	{
		if(a==null || a.length==0) return 0;
        int n = a.length;
		int ans = 0;
		int p=0;
		int q=1;
		List<Points> segments = new ArrayList<Points>();
		for(int i=0; i<n; i++)
		{
			segments.add(new Points(a[i],b[i]));
		}
		int m = segments.size();
		while(p<m && q<m)
		{
			if(segments.get(p).second >= segments.get(q).first)
			{
				q+=1;
			}
			else
			{
				ans+=1;
				p=q;
				q+=1;
			}
		}
		return (ans+1);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n; n = scan.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
		for(int i=0; i<n; i++) a[i] = scan.nextInt();
		for(int i=0; i<n; i++) b[i] = scan.nextInt();
		System.out.println(solve(a,b));
		scan.close();

	}
}
class Points
{
	int first,second;

	public Points(int first, int second) {
		super();
		this.first = first;
		this.second = second;
	}
	
}
