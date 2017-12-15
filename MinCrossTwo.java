package dp;
import java.util.*;
public class MinCrossTwo {

	public static void main(String[] args) {
		int arr[]={20, 4, 1, 3};
		Arrays.sort(arr);
		int length=arr.length;
		System.out.println(minRemovals(arr, 0, length-1));
	}
	public static int minRemovals(int[] arr, int start, int end){
		if(arr[start]*2>arr[end])
			return 0;
		if(start==end-1)
			return 2;//if not possible then the answer will be the length of the array.
		return min(minRemovals(arr, start+1, end)+1, minRemovals(arr, start, end-1)+1);
	}
	public static int min(int x, int y){
		return x<y?x:y;
	}
}
