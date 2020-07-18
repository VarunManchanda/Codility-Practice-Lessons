import java.util.Scanner;
import java.util.Stack;

public class Nesting {
	
	public static int solve(String s)
	{
		Stack<Character> st = new Stack<Character>();
		for(char c : s.toCharArray())
		{
			if(c=='(') st.push('(');
			else
			{
				if(st.empty()) return 0;
				st.pop();
			}
		}
		return (st.empty()==true) ? 1 : 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-- > 0)
		{
			String s; s = scan.next();
			System.out.println(solve(s));
		}
		scan.close();
	}

}
