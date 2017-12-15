package dp;
import java.util.*;
public class LongestCommonSubSeq {
	public static void main(String[] args){
		String x="leakkk";
		String y="leseka";
		int xLength=x.length();
		int yLength=y.length();
		
		System.out.println("LCH:  "+findLCS(x,y,xLength,yLength));
	}
	//Use Memoization to improve time complexity  
	//Use 2d array for memoization
	private static int findLCS(String x,String y,int xIndex,int yIndex){
		if(xIndex == 0 || yIndex == 0)
			return 0;
		else if(x.charAt(xIndex - 1) == y.charAt(yIndex - 1))
			return 1 + findLCS(x, y, xIndex - 1, yIndex - 1);
		else
			return findLCS(x, y, xIndex-1, yIndex)>findLCS(x, y, xIndex, yIndex-1) ? findLCS(x, y, xIndex-1, yIndex) : findLCS(x, y, xIndex, yIndex-1);
	}
}
