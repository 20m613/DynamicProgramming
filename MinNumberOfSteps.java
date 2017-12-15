package dp;

public class MinNumberOfSteps {
	public static void main(String[] args){
		int arr[]={1, 3, 6, 1, 0, 9};
		int length=arr.length;
		int[] min=new int[length];
		
		int i=0;
		for(;i<length;i++)
			min[i]=100;
		i=length-1;
		for(;i>=0;i--){
			if(length<=arr[i]+i)
				min[i]=1;
			else{
				int j=i+1;
				int tempMin=min[j];
				for(;j<=arr[i]+i;j++){
					if(tempMin > min[j])
						tempMin=min[j];
				}
				min[i]=tempMin+1;
			}
		}
//		for(i=0;i<length;i++)
//			System.out.print(min[i]+" ");
		System.out.println("\nMinimum Steps:  "+min[0]);
	}
}
