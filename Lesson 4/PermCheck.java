import java.util.HashMap;
import java.util.Scanner;

public class PermCheck {
	
	public static int solve(int[] A)
	{
		int n = A.length;
        if(n==0) return 0;
        HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
        for(int i : A) m.putIfAbsent(i,1);
        for(int i=1; i<=n; i++) if(m.containsKey(i)==false) return 0;
        return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) arr[i] = scan.nextInt();
		System.out.println(solve(arr));
		scan.close();
	}

}
