import java.util.*;
public class CountSemiPrimes {
	
	public final static int N = 50005;
	public static int primes[] = new int[N];
	
	public static void sieve()
	{
		for(int i=0; i<N; i++) primes[i] = 1;
		primes[0] = primes[1] = 0;
		for(int i=2; i*i<N; i++)
		{
			if(primes[i]==1)
			{
				for(int j=i*i; j<N; j+=i)
				{
					primes[j] = 0;
				}
			}
		}
	}
	public static int[] solve(int n)
	{
		int semi_primes[] = new int[n+5];
		List<Integer> prefix = new ArrayList<Integer>();
		prefix.add(0);
		for(int i=0; i<=n; i++)
		{
			int c = 0;
			for(int j=1; j*j<=i; j++)
			{
				if(i%j==0)
				{
					if((primes[j]==1 && primes[i/j]==1)) c+=2; 
				}
			}
			if(c==2)
			{
				semi_primes[i] = 1;
			}
		}
		for(int i=1; i<=n; i++)
		{
			if(semi_primes[i]==1) prefix.add(prefix.get(prefix.size()-1)+1);
			else prefix.add(prefix.get(prefix.size()-1)+0);
		}
		for(int i=0; i<prefix.size(); i++)
		{
			System.out.println(i+" value is "+prefix.get(i));
		}
		return semi_primes;
	}
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n; n = scan.nextInt();
		sieve();
		int semi_primes[] = solve(n);
		for(int i=0; i<=n; i++) 
			{
				if(semi_primes[i]==1)
				System.out.print(i+" ");
			}
		scan.close();
	}

}
