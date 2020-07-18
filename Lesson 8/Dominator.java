import java.util.HashMap;
import java.util.Scanner;

public class Dominator {

	 public static int solve(int[] A) {
	        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
	        int n = A.length;
	        int m = n/2;
	        for(int i : A)
	        {
	            if(hashMap.containsKey(i))
	            {
	                int v = (int)hashMap.get(i);
	                hashMap.put(i,v+1);
	            }
	            else
	            {
	                hashMap.put(i,1);
	            }
	        }
	        for(int i=0; i<n; i++)
	        {
	           int v = (int)hashMap.get(A[i]);
	           if(v>m) return i;
	        }  
	        return -1;
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
