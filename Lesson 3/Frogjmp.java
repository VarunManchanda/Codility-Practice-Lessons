import java.util.Scanner;

public class Frogjmp {

	public static int solve(int x, int y, int d)
	{
		if(x==y) return 0;
		return (int)Math.ceil((double)(y-x)/d);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int x,y,d; x = scan.nextInt(); y = scan.nextInt(); d = scan.nextInt();
		System.out.println(solve(x,y,d));
		scan.close();
	}

}
