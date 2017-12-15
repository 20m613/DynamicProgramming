package dp;

public class VogueVogueRevolution {
	public static void main(String[] args) {
		//0,1,2,3 are the valid input[] entries
		int[] input={1,1,3,3,0,2,0,2,2};
		System.out.println(maxStyle(input,0, 0, 2));
	}
//	atleast (n/4)-1 style points are possible.as there are only 4 valid moves
//	Wow!!
//	0-->left
//	1-->up
//	2-->right
//	3-->down
	public static int maxStyle(int[] input, int n, int left, int right){
		if(n>=input.length)
			return 0;
		if(input[n]==left || input[n]==right)
			return 1+maxStyle(input, n+1, left, right);
		else
			return max(maxStyle(input, n+1, input[n], right),maxStyle(input, n+1, left, input[n]));//move left foot or right foot
	}
	public static int max(int x,int y){
		return x>y?x:y;
	}
}
