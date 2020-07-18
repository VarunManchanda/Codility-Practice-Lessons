import java.util.Scanner;

public class GenomicRangeQuery {

	public static int[] solve(String s, int[] p, int[] q) {
        int n = s.length();
        int arr[] = new int[n];
        int ans[] = new int[p.length];
        for(int i=0; i<n; i++)
        {
            if(s.charAt(i)=='A') arr[i] = 1;
            else if(s.charAt(i)=='C') arr[i] = 2;
            else if(s.charAt(i)=='G') arr[i] = 3;
			else if(s.charAt(i)=='T') arr[i] = 4;
        }
        ST st = new ST();
        st.init(n);
        st.buildTree(arr,0,n-1,0);
        for(int i=0; i<p.length; i++)
        {
            int l,r; l = p[i]; r = q[i];
            ans[i] = st.query(0,n-1,l,r,0);
        }
        return ans;
    }
	
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String s = ""; s = scan.next();
		Scanner scan1 = new Scanner(System.in);
		int n; n = scan1.nextInt();
		int p[] = new int[n];
		int q[] = new int[n];
		for(int i=0; i<n; i++)
		{
			p[i] = scan1.nextInt();
			q[i] = scan1.nextInt();
		}
		int ans[] = solve(s,p,q);
		for(int i : ans) System.out.print(i+" ");
		scan1.close();
	}

}
class ST
{
    private int n = 0;
    private int tree[];
    public void init(int n)
    {
        this.n = n;
        this.tree = new int[4*n+1];
    }
    public void buildTree(int arr[], int ss, int se, int index)
    {
        if(ss==se) {tree[index] = arr[ss]; return;}
        int mid = (ss+se)/2;
        buildTree(arr,ss,mid,2*index+1);
        buildTree(arr,mid+1,se,2*index+2);
        tree[index] = Integer.min(tree[2*index+1],tree[2*index+2]);
        return;
    }
    public int query(int ss, int se, int qs, int qe, int index)
    {
        //no-overlapping
        if(se<qs || ss>qe) return Integer.MAX_VALUE;
        //full-overlapping
        if(ss>=qs && se<=qe) return tree[index];
        //partial-overlapping
        int mid = (ss+se)/2;
        int l = query(ss,mid,qs,qe,2*index+1);
        int r = query(mid+1,se,qs,qe,2*index+2);
        return Integer.min(l,r);
    }
    public void printTree()
    {
        for(int i=0; i<4*n; i++)
        {
            System.out.println(i+" is "+tree[i]);
        }
    }
}