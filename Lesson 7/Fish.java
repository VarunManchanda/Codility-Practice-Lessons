import java.util.*;
class Pair
{
	public int a,b;
	public Pair(int i, int j) {
		this.a = i;
		this.b = j;
	}

	
}
public class Fish {

	public static int solve(int a[], int b[])
	{
		int n = a.length;
		int ans = 0;
		Stack<Pair> st  = new Stack<Pair>();
		for(int i=0; i<n; i++)
		{
			int fishSize =  a[i];
			int direction = b[i];
			if(direction==0)
			{
				while(!st.empty() && st.peek().a < fishSize && st.peek().b==1) st.pop();
				if(!st.empty() && st.peek().b==1) continue;
				else
				{
					Pair obj = new Pair();
					obj.a = fishSize;
					obj.b = 0;
					st.push(obj);
				}
			}
			else
			{
				Pair obj = new Pair();
				obj.a = fishSize;
				obj.b = 1;
				st.push(obj);
			}
		}
		while(!st.empty())
		{
			ans++;
			st.pop();
		}
		return ans;
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
