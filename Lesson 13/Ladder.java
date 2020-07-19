import java.time.Duration;
import java.time.Instant;
import java.util.*;
public class Ladder {

	public static final int L = 50001;
    public static List<Integer> pre()
    {
        List<Integer> fib = new ArrayList<Integer>();
        fib.add(0);
        fib.add(1);
        int a = 0;
        int b = 1;
        for(int i=2; i<=L; i++)
        {
            int c = a+b; c %= (1 << 30); // it is same as 2^30
            a = b;
            b = c;
            fib.add(c);
        }
        return fib;
    }
    public static int fastPow(int a, int b)
    {
        long ans = 1;
        while(b>0)
        {
            if((b&1)==1) ans *= a;
            a *= a;
            b >>= 1; // b = b/2;
        }
        return (int)ans;
    }
    public int[] solve(int[] A, int[] B) {
        int n = A.length;
        int ans[] = new int[n];
        List<Integer> fib = pre();
        for(int i=0; i<n; i++)
        {
            ans[i] = (fib.get(A[i]+1) % fastPow(2,B[i])); // 2^B[i]
        }
        return ans;
    }
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);	
		int n; n = scan.nextInt();
		Instant start = Instant.now();
		//solve(n);
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		System.out.println("Time taken by Brute Force: "+ timeElapsed.toSeconds() +" seconds");
		start = Instant.now();
		//solve(n);
		end = Instant.now();
		timeElapsed = Duration.between(start, end);
		System.out.println("Time taken by DP: "+ timeElapsed.toSeconds() +" seconds");
		scan.close();
	}

}
