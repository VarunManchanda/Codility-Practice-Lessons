import java.util.*;
public class CountTriangles {

	public static int solveBF(int arr[])
	{
		int ans = 0;
		int n = arr.length;
		for(int i=0; i<n; i++) 
		{
			for(int j=i+1; j<n; j++) 
			{
				for(int k=j+1; k<n; k++)
				{
					if(arr[i]+arr[j]>arr[k] && arr[j]+arr[k]>arr[i] && arr[k]+arr[i]>arr[j]) ans++;
				}
			}
		}
				
		return ans;
	}
	public static int solveFA(int arr[])
	{
		int ans = 0;
	    int s = 0, m = 0;
		int n = arr.length;
		Arrays.sort(arr);
		for(int i : arr) System.out.print(i+" ");
		System.out.println();
		for(int e=n-1; e>=1; e--)
		{
			s = 0;
			m = e-1;
			while(s<m)
			{
				if(arr[s]+arr[m] > arr[e])
				{
					System.out.println("arr[s]->"+arr[s]+"arr[m]->"+arr[m]+"arr[e]->"+arr[e]);
					ans += m-s;
					m-=1;
				}
				else
				{
					s+=1;
				}
			}
			
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n; n = scan.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) arr[i] = scan.nextInt();
		System.out.println(solveFA(arr));
		System.out.println("Correct answer->"+solveFA(arr));
		scan.close();
	}

}
