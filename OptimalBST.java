package dp;

//Did not understand!!
public class OptimalBST {
	public static void main(String[] args) {
		int keys[] = {3,4,5};
        int freq[] = {3,4,5};
        int n = freq.length;
        System.out.println("Cost of Optimal BST is " +
                         optimalSearchTree(freq, 0, n-1));
	}
	public static int optimalSearchTree(int[] freq, int i, int j){
		if(i>j)
			return 0;
		if(i==j)
			return freq[i];
		int freqSum=getFreqSum(freq, i, j);
		//System.out.println("freqSum:  "+freqSum);
		//System.out.println("i:  "+i+"  j:  "+j);
		int min=Integer.MAX_VALUE;
		for(int r=i; r<=j; r++){
			System.out.println("i:  "+i+"  r:  "+r+"  j:  "+j);
			int cost=optimalSearchTree(freq, i, r-1)+optimalSearchTree(freq, r+1, j);
			
			System.out.println("Sum:  "+cost);
			if(cost<min)
				min=cost;
		}
		return freqSum+min;
	}
	
	public static int getFreqSum(int[] freq, int i, int j){
		int sum=0;
		for(int k=i; k<=j; k++)
			sum+=freq[k];
		return sum;
	}
}


