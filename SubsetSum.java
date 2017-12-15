package dp;

public class SubsetSum {
	public static void main(String[] arrgs){
		int sum=17;//test case 0
		int[] input={3, 34, 4, 12, 5, 2};
		System.out.println("Sum: "+sum+" is present: "+isSumPresent(input, sum, 0));
	}
	private static boolean isSumPresent(int[] input,int remaining,int index){
		//System.out.println("input.length:  "+input.length+" index:  "+index);
		//System.out.println("Remaining:  "+remaining);
		if(index == input.length && remaining > 0){
			//System.out.println("Remaining:  "+remaining+"  index:  "+index);
			return false;
		}
		else if(index == input.length && remaining == 0){
			//System.out.println("Remaining:  "+remaining+"  index:  "+index);
			return true;
		}
		int tempRemaining=remaining;
		if(input[index]<=remaining)
			remaining-=input[index];
		
		return isSumPresent(input, remaining, index+1) || isSumPresent(input, tempRemaining, index+1);
	}
}
