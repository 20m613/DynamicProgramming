package dp;

public class DiceThrow {
	public static void main(String[] args) {
		
		//int n=3,m=6,sum=8;
		int n=3,m=4,sum=5;
		//int n=10,m=10,sum=100;
		//int n=3,m=3,sum=9;
		int lookUp[]=new int[sum+1];
		for(int i=0;i<=sum;i++)
			lookUp[i]=-1;
		System.out.println("fn("+n+", "+m+", "+sum+"):  "+waysToGetSum(n, m, sum, sum, n));
		System.out.println("Done!!");
	}
	public static int waysToGetSum(int n, int m, int sum, int initialSum , int initialDices){

		if(n*m<sum)
			return 0;
		if((initialDices-n)*m<(initialSum-sum))
			return 0;
		if(n==1 && sum<=m && sum!=0 && (initialDices-n)*m >=(initialSum-sum)){//&& ((initialDices-n)*m >=(initialSum-sum)))
			System.out.println("return 1:  Sum:  "+sum+"  n:  "+n);
			return 1;
		}
		
		int ways=0;
		//System.out.println("n:  "+(n)+"  sum: "+(sum));
		
		//System.out.println("Inside:  n:  "+(n)+"  sum: "+(sum));
		
		for(int i=n-1; i>=1;i--){
			for(int j=sum-1;j>=i ;j--){
				System.out.println("n:  "+(i)+"  sum: "+(j));//+"  i*m:  "+(i*m));
				ways+=waysToGetSum(i, m, j, initialSum, initialDices);//get the sum-1 from dice-1 dices for all the sums for all the dices
			}
		}
		return ways;
	}
}
