package dp;

public class MaxPathSumInTriangle {
	public static void main(String[] args){
//		int[][] triangle={{3,0,0,0},
//						 {7,4,0,0},
//						 {3,4,6,0},
//						 {8,5,9,3}};
		int[][] triangle={{8,0,0,0},
						  {-4,4,0,0},
						  {2,2,6,0},
						  {1,1,1,1}};
		final int row=4,col=4;
		
		for(int i=row-2;i>=0;i--){
			for(int j=0;j<col;j++){
				int temp1=triangle[i][j]+triangle[i+1][j];
				if(j+1<col){
					int temp2=triangle[i][j]+triangle[i+1][j+1];
					triangle[i][j]=(temp1>temp2?temp1:temp2);
				}
				else
					triangle[i][j]=temp1;
			}
		}
		System.out.println(triangle[0][0]);
	}
}
