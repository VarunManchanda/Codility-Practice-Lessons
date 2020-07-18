import java.util.Scanner;

public class MaxCounters {

	public static void solve(int arr[], int n, int k)
	{
		if(n==0) return;
		int m = Integer.MIN_VALUE;
		int s = 0;
		int ans[] = new int[k+1];
		for(int i=1; i<=k; i++) ans[i] = 0;
		for(int i : arr)
		{
			if(k+1==i)
			{
				m = Math.max(m,s);
			}
			else
			{
				if(m==Integer.MIN_VALUE)
				{
					ans[i]+=1;
					s = Math.max(s,ans[i]);
				}
				else if(ans[i]<=m)
				{
					ans[i] = m;
					ans[i]+=1;
					s = Math.max(s,ans[i]);
				}
				else
				{
					ans[i]++;
					s = Math.max(s,ans[i]);
				}
			}
		}
		for(int i=1; i<=k; i++) if(ans[i]==0 || ans[i]<m) ans[i] = m;
		for(int i=1; i<=k ;i++) System.out.print(ans[i]+" ");
		return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		int n = scan.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) arr[i] = scan.nextInt();
		solve(arr,n,k);
		scan.close();
	}
}
