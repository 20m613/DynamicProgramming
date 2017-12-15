package dp;

public class GameOne {
	public static void main(String[] args) {
		//int[] in={8, 15, 3, 7};
		//int[] in={20, 30, 2, 2, 2, 10};
		int[] in={1,4,6,8};
		int length=in.length;
		System.out.println("maxResult:  "+fn(in,0,length-1));
	}
	
	public static int fn(int[] in, int i, int j){
		if(i==j)
			return in[i];
		if(i==j-1)
			return max(in[i],in[j]);
		return max(in[i]+min(fn(in,i+2,j),fn(in,i+1,j-1)),//select i'th element and then the opponent will select the element which leaves us with the min val. 
				   in[j]+min(fn(in,i+1,j-1),fn(in,i,j-2)));//select j'th element
	}
	
	public static int max(int x,int y){
		return x>y?x:y;
	}
	public static int min(int x,int y){
		return x<y?x:y;
	}
}
