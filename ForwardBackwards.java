package dp;
import java.util.Scanner;
public class ForwardBackwards {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String str="DYNAMICPROGRAMMINGMANYTIMES";
		System.out.println(getLength(str));
		
	}
	//O(n^2).. can do better
	public static int getLength(String str){
		int length=str.length();
		int max=0;
		for(int i=0;i<length;){
			int k=i;
			int temp=0;
			for(int j=length-1;j>i;j--){
				if(str.charAt(i)==str.charAt(j)){
					i++;
					temp++;
					max=max>temp?max:temp;
				}
				else
					temp=0;
			}
			i=k+1;
		}
		return max;
	}
}
