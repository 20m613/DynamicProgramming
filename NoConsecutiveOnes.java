package dp;

//M1cro50f7
public class NoConsecutiveOnes {

	public static void main(String[] args) {
		int n=21;
		System.out.println("for n: "+n+"= "+count(n,0));
	}
	public static int count(int n, int lastBit){
		//int countVar=0;
		if(n==0)
			return 1;
		if(lastBit==0)
			return count(n-1, 0) + count(n-1, 1);
			//countVar=count(n-1, 0) + count(n-1, 1);
		else 
			return count(n-1, 0);
			//countVar=count(n-1, 0);
		//return countVar;
			
	}
}
