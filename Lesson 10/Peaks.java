import java.util.*;
public class Peaks
{
	public static boolean check(int arr[], HashMap<Integer,Integer> hashMap, int s, int e)
    {
        for(int i=s; i<=e; i++) if(hashMap.containsKey(i)) return true;
        return false;
    }
	public static int solution(int arr[])
	{
		int n = arr.length;
        int ans = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        List<Integer> factors = new ArrayList<Integer>();
        for(int i=1; i<n-1; i++)
            if(arr[i-1]<arr[i] && arr[i]>arr[i+1]) hashMap.put(i,1);
        for(int i=1; i*i<=n; i++)
        {
            if(n%i==0)
            {
            	if(i*i==n) factors.add(i);
            	else {factors.add(i); factors.add(n/i);}
            }
        }
        Collections.sort(factors);
        for(int i : factors)
        {		
            int no_of_blocks  = i; 
            int block_size    = n/i;
            int s = 0;
            int e = block_size;
            int peaks = 0;
            for(int j=1; j<=no_of_blocks; j++)
            {
                if(check(arr,hashMap,s,e-1)==true) peaks++;
                else break;
                s = e;
                e += block_size;										//changed e*=2 -> e += block_size;
            }
            if(peaks>=no_of_blocks) ans=i;					//changed a+=1  ->  ans=i
        }
        return ans;
	}
	public static void main(String []args)
	{
		Scanner scan = new Scanner(System.in);
		int n; n = scan.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) arr[i] = scan.nextInt();
		System.out.println(solution(arr));
		scan.close();
	}
}
