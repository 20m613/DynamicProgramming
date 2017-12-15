package dp;
import java.util.*;

public class MinDeletionPalindrome {
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
	    String in;
	    int length=0;
	    int t=sc.nextInt();
	    while(--t>=0){
	        in=sc.next();
		    length=in.length();
		    //System.out.println("Length:  "+length);
		    int[][] lookUp=new int[length][length];
		    for(int i=0;i<length;i++)
		    	for(int j=0;j<length;j++)
		    		lookUp[i][j]=-1;
		    System.out.println(("LPS:  "+largestPalindrome(in, 0, length-1,lookUp)));
		    System.out.println((length-largestPalindrome(in, 0, length-1,lookUp)));
	    }
	}
	public static int largestPalindrome(String in, int start, int end,int[][] lookUp){
		//System.out.println("Start:  "+start+"  end:  "+end);
		if(lookUp[start][end]!=-1){
			//System.out.println(start+" "+end+"  in lookUp:  "+lookUp[start][end]);
			return lookUp[start][end];
		}
		if(end == start)
			return 1;
		if(end < start)
			return 0;
		if(in.charAt(start) == in.charAt(end)){
			lookUp[start][end]=(2+largestPalindrome(in, start+1, end-1,lookUp));//don't use ++start || start++. wont work
			return lookUp[start][end];
		}
		else
			lookUp[start][end]= max(largestPalindrome(in, start+1, end, lookUp),largestPalindrome(in, start, end-1, lookUp));
		return lookUp[start][end];
	}
	public static int max(int x, int y){
		return x>y?x:y;
	}
}
