import java.util.Scanner;
import java.util.Stack;

public class Brackets {
	public static int solve(String s) {
        Stack<Character> st = new Stack<Character>();
        for(char c : s.toCharArray())
        {
            if(c=='(' || c=='{' || c=='[')
                st.push(c);
            else
            {
                if(st.empty()==true) return 0;
                else if(c==')' && st.peek()!='(') return 0;
                else if(c=='}' && st.peek()!='{') return 0;
                else if(c==']' && st.peek()!='[') return 0;
                st.pop();
            }
        }
        return (st.empty()==true) ? 1 : 0;
    }
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s; s = scan.next();
		System.out.println(solve(s));
		scan.close();
	}

}
