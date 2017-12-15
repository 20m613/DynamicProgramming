package dp;

public class SetIntoKsubsets {
	public static void main(String[] args){
		int n=2,k=1;
		System.out.println("SubSets:  "+getNumberOfSubsets(n,k));
	}
	public static int getNumberOfSubsets(int n,int k){
		if(n==k)
			return 1;
		if(n==1 || k==1)
			return 1;
			   //Selected!!		why k not n?  //Not Selected!!
		return k*getNumberOfSubsets(n-1, k-1)+getNumberOfSubsets(n-1, k);
	}
}
