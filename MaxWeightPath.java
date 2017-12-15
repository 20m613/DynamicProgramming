package dp;

public class MaxWeightPath {
	public static void main(String[] args){
		int  mat[][] = {{ 4, 2 ,3 ,4 ,1 },
                { 2 , 9 ,1 ,10 ,5 },
                {15, 1 ,3 , 0 ,20 },
                {16 ,92, 41, 44 ,1},
                {8, 142, 6, 4, 8} };
		int n=5;
		int mat2[][]=new int[5][5];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				mat2[i][j]=0;
		mat2[0][0]=mat[0][0];
		for(int i=1;i<n;i++){
			for(int j=0;j<=i;j++){
				if(i==j)
					mat2[i][j]=mat[i][j]+mat2[i-1][j-1];
				else if(j==0)
					mat2[i][j]=mat[i][j]+mat2[i-1][j];
				else
					mat2[i][j]=mat[i-1][j-1]>mat[i-1][j]?mat2[i-1][j-1]+mat[i][j]:mat2[i-1][j]+mat[i][j];
			}
		}
		int max=mat2[n-1][0];
		for(int i=0;i<n;i++)
			if(max<mat2[n-1][i])
				max=mat2[n-1][i];
		System.out.println("max:  "+max);
		for(int i=0;i<n;i++){
			System.out.println();
			for(int j=0;j<n;j++){
				System.out.print(mat2[i][j]+" ");
			}
		}
	}
}
