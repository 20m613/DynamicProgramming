package dp;

public class LeastCostPath {
	public static void main(String[] args){
		int mat[][]={
						{1,2,3},
						{4,8,2},
						{1,5,3},
					};
		int i=2,j=2;
		int min=mat[i][j]+mat[0][0];
		while(i!=0 && j!=0){
			int tempMin=mat[i][j-1];
			int tempI=i;
			int tempJ=j-1;
			if(i!=0 && j!=0 && tempMin>mat[i-1][j-1]){
				tempI=i;
				tempJ=j;
				System.out.println("Selected:  "+mat[i-1][j-1]);
				tempMin=mat[i-1][j-1];
				tempI-=1;
				tempJ-=1;
			}
			if(i!=0 && tempMin>mat[i-1][j]){
				tempI=i;
				tempJ=j;
				System.out.println("Selected:  "+mat[i-1][j]);
				tempMin=mat[i-1][j];
				tempI-=1;
			}
			i=tempI;
			j=tempJ;
			min+=tempMin;
			System.out.println("i:  "+i+"  j:  "+j);
		}
		System.out.println("min:  "+min);
	}
	
}
