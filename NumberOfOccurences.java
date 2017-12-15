package dp;
import java.util.Scanner;
public class NumberOfOccurences {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(--t>=0){
			String text="";
			String pattern="";
			int m=sc.nextInt();
			int n=sc.nextInt();
			text=sc.next();
			pattern=sc.next();
			System.out.println(getOccurences(text, pattern, m, n));
		}
	}
	public static int getOccurences(String text, String pattern, int m, int n){
		if((m==0 && n==0)||n==0)
			return 1;
		if(m==0)
			return 0;
		if(text.charAt(m-1)==pattern.charAt(n-1))
			return getOccurences(text, pattern, m-1, n-1)+getOccurences(text, pattern, m-1, n);
		else
			return getOccurences(text, pattern, m-1, n);
	}
}
