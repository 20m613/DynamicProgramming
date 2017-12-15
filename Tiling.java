package dp;

public class Tiling {
	public static void main(String[] args){
		int n=1;
		long lookUp[]=new long[n+1];
		for(int i=0;i<=n;i++)
			lookUp[i]=-1;
		System.out.println("number of ways for tiling: "+tiling(n,lookUp));
	}
	//Memoization Rocks!!
	private static long tiling(int n,long [] lookUp){
		if(lookUp[n]!=-1)
			return lookUp[n];
		if(n<=2)
			return n;
		long count=tiling(n-1,lookUp)+tiling(n-2,lookUp);
		lookUp[n]=count;
		return count;
	}
}
