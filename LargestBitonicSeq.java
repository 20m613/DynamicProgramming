package dp;

import java.util.Scanner;

public class LargestBitonicSeq {
	public static void main(String[] args) {
		//int array[]={0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5,13, 3, 11, 7, 15};
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(--t>=0){
			int n=sc.nextInt();
			int array[]=new int[n];
			for(int i=0;i<n;i++)
				array[i]=sc.nextInt();
			System.out.println(getLargestBitonicSeq(array));
		}
	}
	public static int getLargestBitonicSeq(int[] array){
		int length=array.length;
		int LIS[]=new int [length];
		int LDS[]=new int[length];
		for(int i=0;i<length;i++)
			LIS[i]=LDS[i]=1;
		for(int i=1;i<length;i++){
			for(int j=0;j<i;j++){
				if(array[i]>array[j] && LIS[i]<LIS[j]+1)
					LIS[i]=LIS[j]+1;
			}
		}
		for(int i=length-2;i>=0;i--){
			for(int j=length-1;j>i;j--){
				if(array[i]>array[j] && LDS[i]<LDS[j]+1)
					LDS[i]=LDS[j]+1;
			}
		}
		int max=LIS[0]+LDS[0]-1;
		for(int i=1;i<length;i++){
			//System.out.println("LIS["+i+"]:  "+LIS[i]+"    LDS["+i+"]:  "+LDS[i]);
			int temp=LIS[i]+LDS[i]-1;
			max=max>temp?max:temp;
		}
		return max;
	}

}
