package dp;

public class MaxDecValPath {
	public static void main(String[] args) {
		int row=4,col=4;
		int mat[][]={{1, 1, 0, 1},
            		 {0, 1, 1, 0},
            		 {1, 0, 0, 1},
            		 {1, 0, 1, 1}};
		System.out.println("\nMax:  "+getMaxDecVal(mat));
	}
	public static int getMaxDecVal(int[][] mat){
		int row=4,col=4;
		int n=row+col-2;
		int[][] a=new int[row][col];
		for(int i=0;i<row;i++)
			for(int j=0;j<col;j++)
				a[i][j]=0;
		a[row-1][col-1]=mat[row-1][col-1];
		for(int i=row-1;i>=1;i--){
			for(int j=col-1;j>=1;j--){
				int t1=a[i][j]+mat[i-1][j]*pow(2,n-(i+j-1));
				int t2=a[i][j]+mat[i][j-1]*pow(2,n-(i+j-1));
				a[i-1][j]=a[i-1][j]>t1?a[i-1][j]:t1;
				a[i][j-1]=a[i][j-1]>t2?a[i][j-1]:t2;
			}
		}
		int t1=a[0][1]+mat[0][0]*pow(2,n);
		int t2=a[1][0]+mat[0][0]*pow(2,n);
		a[0][0]=t1>t2?t1:t2;
		for(int i=0;i<row;i++){
			System.out.println();
			for(int j=0;j<col;j++)
				System.out.print(a[i][j]+" ");
		}
		return a[0][0];
	}
	public static int pow(int base, int power){
		int ans=1;
		for(int i=0;i<power; i++)
			ans*=base;
		return ans;
	}
}
