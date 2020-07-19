import java.util.*;
public class NailingPlanks {

	public static boolean checkBF(int a[], int b[], int c[], int mid)
	{
		int n = a.length;
		boolean planksBool[] = new boolean[n];
		for(int i=0; i<=mid; i++)
		{
			for(int j=0; j<a.length; j++)
			{
				if(c[i]>=a[j] && c[i]<=b[j]) planksBool[j]=true;
			}
		}
		for(boolean i : planksBool) if(i==false) return false;
		return true;
	}
	public static boolean lower_bound(int []nails, int s, int e)
	{
		int lb = 0;
		int ub = nails.length-1;
		while(lb<=ub)
		{
			int mid = lb + (ub-lb)/2;
			if(nails[mid]>=s && nails[mid]<=e) return true;
			else if(nails[mid]<s) lb = mid + 1;
			else ub = mid -1;
			
		}
		return false;
	}
	public static boolean checkRE(int a[], int b[], int c[], int mid)
	{
		int n = a.length;
		int nails[] = new int[mid+1];
		for(int i=0; i<=mid; i++) nails[i]=c[i];
		Arrays.sort(nails);
		for(int i=0; i<n; i++)
		{
			if(!lower_bound(nails,a[i],b[i])) return false;
		}
		return true;
	}
	public static int solve(int A[], int B[], int C[])
	{
		int s = 0;
		int e = C.length-1;
		int ans = 0;
		boolean flag = false;
		while(s<=e)
		{
			int mid=s+(e-s)/2;
			if(checkRE(A,B,C,mid)==true)
			{
				flag = true;
				ans = mid;
				e   = mid-1;
			}
			else s = mid+1;
		}
		if(ans==C.length && flag) return -1; // i did calculation but i didn't find the answer
		else if(ans==0 && !flag ) return -1; // i never did the calculation
		return ans+1;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n; n = scan.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
		for(int i=0; i<n; i++) a[i]=scan.nextInt();
		for(int i=0; i<n; i++) b[i]=scan.nextInt();
		int k; k = scan.nextInt();
		int c[] = new int[k];
		for(int i=0; i<k; i++) c[i]=scan.nextInt();
		System.out.println(solve(a,b,c));
		scan.close();
	}

}
