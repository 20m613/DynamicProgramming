package dp;
import java.util.*;
public class MaxProductCutt {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(--t>=0){
			int n=sc.nextInt();
			int lookUp[]=new int[n+1];
			for(int i=0;i<=n;i++)
				lookUp[i]=-1;
			System.out.println(getMax(n,lookUp));
		}
	}
	public static int getMax(int n, int[] lookUp){
		int max=0;
		if(lookUp[n]!=-1)
			return lookUp[n];
		if(n==0 || n==1)
			return 0;
		for(int i=1;i<n;i++)
			max=max(max, i*(n-i), getMax(n-i,lookUp)*i);
		lookUp[n]=max;
		return max;
			
	}
	public static int max(int x, int y, int z){
		int tMax=x>y?x:y;
		return tMax>z?tMax:z;
	}
}
