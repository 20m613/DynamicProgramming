package dp;

public class Dancer {

	public static void main(String[] args) {
//		int[] score={9,1,6,8,7,1,14,2};
//		int[] wait= {1,4,2,5,4,3,0 ,1};
		int[] score={1,1,1,1,1};
		int[] wait= {1,10,1,1,1};
//		int[] score={1,2,3};
//		int wait[]={2,1,1};
		System.out.println(getMaxScore(score, wait, 0));
	}
	public static int getMaxScore(int[] score,int[] wait, int index){
		if(index>=score.length)
			return 0;
		
		if(index==score.length-1)
			return score[index];
		int max=0;
		for(int k=index;k<score.length;k++){
			int temp=0;
			temp=score[k]+getMaxScore(score, wait, k+(wait[k]==0?1:wait[k]));
			max=max>temp?max:temp;
			System.out.println("k:  "+k+"  max:  "+max);
		}
		return max;
	}
}
