package dp;

public class LargestSubArray {
	//Kadane's algo!!
	public static void main(String[] args){
		int[] array={-2, -3, 4, -1, -2, 1, 5, -3};
		//System.out.println("getMaxProductSubArray:  "+getMaxProductSubArray(array));
		System.out.println("getMaxSubArraySum:  "+getMaxSubArraySum(array));
		
	}
	
	
	public static int getMaxSubArraySum(int[] array){
		int i=1,length=array.length;
		int sum=array[0];
		int temp=sum,maxSum=sum;
		for(;i<length;i++){
			temp=temp+array[i]<array[i]?array[i]:temp+array[i];
			sum=sum>temp?sum:temp;
			//maxSum=sum>maxSum?sum:maxSum;
			//System.out.println("Sum:  "+sum);
		}
		//System.out.println("LargestSubArraySum:  "+sum);
		return sum;
		//System.out.println("MaxSum:  "+maxSum);
	}
	
//	public static int getMaxProductSubArray(int[] array){
//	
//	}
}
