package dp;
import java.util.Scanner;
class LargestSubArrayProd {
	public static void main (String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(--t>=0){
			int n=sc.nextInt();
		    int[] array=new int[n];
			for(int i=0;i<n;i++)
				array[i]=sc.nextInt();
			System.out.println(getLargestSubArrayProd(array));
		}
	}
	public static int getLargestSubArrayProd(int[] array){
		int temp=1;
		int prodMax=Integer.MIN_VALUE;
		int length=array.length;
		int firstNegative=-1;//how to keep track of the first -ve included in temp??
		int prodTillFirstNegative=1;
		boolean prodSet=false;
		for(int i=0;i<length;i++){
			temp=temp*array[i];
			if(temp<0 && firstNegative!=-1){
				//divide by all the numbers till firstNegative  except for zero's
				int temp2=temp/prodTillFirstNegative>temp/array[i]?temp/prodTillFirstNegative:temp/array[i];
				prodMax=prodMax>temp2?prodMax:temp2;
			}
			prodMax=prodMax>temp?prodMax:temp;
			if(temp==0){
				temp=1;
				firstNegative=-1;
			}
			if(array[i]<0 && firstNegative ==-1){
				firstNegative=i;
				
			}
			if(array[i]==0){
				prodTillFirstNegative=1;
				prodSet=false;
			}
			else if(!prodSet){
				prodTillFirstNegative*=array[i];
				if(array[i]<0)
					prodSet=true;
			}
		}
		return prodMax;
	}
}