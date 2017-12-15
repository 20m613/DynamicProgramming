package dp;
public class tiles {
	public static void main(String[] args){
		int n=2000;
		long[] lookUp=new long[n+1];
		for(int i=0;i<=n;i++)
			lookUp[i]=-1;
		System.out.println("ways: "+countWays(n,lookUp));
	}
	private static long countWays(int n,long[] lookUp){
		if(n<=0)
			return 0;
		if(lookUp[n]!=-1)
			return lookUp[n];
		if(n<3)
			return 1;
		if(n==4)
			return 2;
		long ways=countWays(n-1, lookUp)+countWays(n-4, lookUp);
		lookUp[n]=ways;
		return ways;
	}
}
