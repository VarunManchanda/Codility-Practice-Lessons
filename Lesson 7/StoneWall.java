import java.util.*;
public class StoneWall {

	public static int solve(int arr[])
	{
		Stack<Integer> st = new Stack<Integer>();
		int ans = 0;
		for(int i : arr)
		{
			while(!st.empty() && st.peek() > i) st.pop();
			if(!st.empty() && st.peek()==i) continue;
			else
			{
				ans+=1;
				st.push(i);
			}
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
