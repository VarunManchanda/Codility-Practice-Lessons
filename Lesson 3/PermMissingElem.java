
public class PermMissingElem {

	public static int solve(int[] A) {
        long sum = 0;
        long n = A.length; n+=1;
        for(int i : A) sum+=i;
        return (int) ((n*(n+1)/2) - sum);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
