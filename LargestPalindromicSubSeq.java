package dp;

public class LargestPalindromicSubSeq {
	public static void main(String[] args) {
		//String str="MAHDYNAMICPROGRAMZLETMESHOWYOUTHEM";
		String str="RECURSION";
		int[][] hash=new int [str.length()][str.length()];
		int length=str.length();
		for(int i=0;i<length;i++)
			for(int j=0;j<length;j++)
				hash[i][j]=-1;
		System.out.println(getCount(str, 0, str.length()-1,hash));
	}	
	//using 2D array to store the values already  calculated
	public static int getCount(String str, int start, int end, int[][] hash){
		if(hash[start][end]!=-1)
			return hash[start][end];
		if(start>end)
			return 0;
		if(start==end)
			return 1;
		if(str.charAt(start)==str.charAt(end))
			hash[start][end] = 2+getCount(str, start+1, end-1,hash);
		else 
			hash[start][end]= max(getCount(str, start+1, end,hash),getCount(str, start, end-1,hash));
		return hash[start][end];
	}
	public static int max(int x, int y){
		return x>y?x:y;
	}

}
