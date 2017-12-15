package dp;
import java.util.*;

public class NthStair {
	public static void main(String[] args){
		long[] lookUp;
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		lookUp=new long[n+1];
		for(int i=0;i<=n;i++)
			lookUp[i]=-1;
		System.out.println("Total Ways:  "+count(n,lookUp));
	}
	//Optimize using memoization: LookUp[]
	//More Generalised problem.. N steps and can take at max m steps at a time, such that 1<=steps<=m
	//use for loop for running from 1 to m and add the result of all the calls and return result.
	//See GeeksForGeeks
	public static long count(int stairs,long[] lookUp){
		
		if(stairs==0)
			return 1;
		else if(stairs<0)
			return 0;
		if(lookUp[stairs]!=-1)
			return lookUp[stairs];
		long left=count(stairs-1,lookUp);
		long right=count(stairs-2,lookUp);
		lookUp[stairs]=left+right;
		return left+right;
		
		//return lookUp[stairs];
		
	}
}
