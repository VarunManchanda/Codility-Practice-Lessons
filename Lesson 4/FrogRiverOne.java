import java.util.*;
public class FrogRiverOne {
	//Time Complexity:- O(n)
	//Space Complexity:- O(n
	public static int solve(int x, int arr[])
	{
		int n = arr.length;
		int vis[] = new int[x];
		int timer = -1;
		for(int i=0; i<x; i++) vis[i] = 0; 
		for(int i=0;i <n; i++) if(vis[arr[i]-1]==0) {vis[arr[i]-1] = 1; timer = i;}
		for(int i : vis) if(i==0) return -1;
		return timer;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n; n = scan.nextInt(); //take input of size of given leaves array
		int arr[] = new int[n];
		for(int i=0; i<n; i++) arr[i] = scan.nextInt();
		int x; x = scan.nextInt(); //take input of number of unique paths positions
		System.out.println(solve(x,arr));
		scan.close();
	}
//	Algorithm:-
//	1)mark all positions with 0 meaning leaves has not started to fall down
//	2)now iterate over the array provided 
//	3)for every leave that is not marked first, mark it and store its time value
//	4)in last check if all positions are marked, if it says no then there is no way for frog to cross
//	5)else return timer

}
