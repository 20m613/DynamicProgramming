package dp;
import java.util.*;

public class WildCardMatching {
	public static void main(String[] args){
		String pattern,text;
		Scanner sc=new Scanner(System.in);
		pattern=sc.next();
		text=sc.next();
		int patternLength=pattern.length();
		int textLength=text.length();
		boolean[][] table=new boolean[textLength][patternLength];//[i][j]
		int i=0,j=0;
		for(;i<1;i++)
			for(j=1;j<patternLength;j++)
				table[i][j]=false;
		for(i=0;i<1;i++)
			for(j=1;j<textLength;j++)
				table[j][i]=false;
		table[0][0]=true;

		for(i=1;i<textLength;i++){
			for(j=1;j<patternLength;j++){
				if(pattern.charAt(j)=='*'){
					table[i][j]=table[i-1][j] || table[i][j-1];
				}
				else if(text.charAt(i)==pattern.charAt(j) || pattern.charAt(j)=='?'){
					table[i][j]=table[i-1][j-1];
				}
				else
					table[i][j]=false;
			}
		}
		
		System.out.println("text matches the pattern:  "+table[textLength-1][patternLength-1]);
	}
}
