package dp;
import java.util.*;
public class LCHThreeStrings {
	public static void main(String[] args){
		String x="geek";
		String y="geeksfor";
		String z="geeksforgeeks";
		int xLength=x.length();
		int yLength=y.length();
		int zLength=z.length();
		
		System.out.println("LCH:  "+findLCS(x,y,z,xLength,yLength,zLength));
	}
	//Use Memoization to improve time complexity
	private static int findLCS(String x,String y,String z,int xIndex,int yIndex,int zIndex){
		if(xIndex == 0 || yIndex == 0 || zIndex==0) 
			return 0;
		else if((x.charAt(xIndex - 1) == y.charAt(yIndex - 1))&& (z.charAt(zIndex-1)==x.charAt(xIndex-1))){	
			//System.out.println("x: "+x.charAt(xIndex-1)+"\ny:  "+y.charAt(yIndex-1)+"\nz:  "+z.charAt(zIndex-1));
			return 1 + findLCS(x, y, z, xIndex - 1, yIndex - 1, zIndex - 1);
		}
		else{
			//System.out.println("x: "+x.charAt(xIndex-1)+"\ny:  "+y.charAt(yIndex-1)+"\nz:  "+z.charAt(zIndex-1));
			int xmax=findLCS(x, y, z, xIndex-1, yIndex, zIndex);
			int ymax=findLCS(x, y, z, xIndex, yIndex-1, zIndex);
			int zmax=findLCS(x, y, z, xIndex, yIndex, zIndex-1);
			int max=(xmax>ymax?xmax:ymax);
			max=(max>zmax?max:zmax);
			return max;
		}
	}
}