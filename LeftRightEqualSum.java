package dp;
//micr050f7
public class LeftRightEqualSum {
	public static void main(String[] args) {
		//String str="105380023";
		String str="1538123";
		System.out.println(":  "+getMaxLength(str));
	}
	//try for every mid point.Given length of the subString should be even
	public static int getMaxLength(String str){
		int n=str.length();
		int maxLength=0;
		for(int i=0;i<=n-2;i++){
			int leftSum= 0,rightSum= 0;
			int l=i,r=i+1;
			while(l>=0 && r<=n-1){
				int length=0;
				leftSum+=str.charAt(l)-'0';
				rightSum+=str.charAt(r)-'0';
				if(leftSum==rightSum ){
					length=r-l+1;
					maxLength=(maxLength>length?maxLength:length);
				}
				l--;
				r++;
			}
		}
		return maxLength;
	}
	public static int getMax(int a, int b){
		return a>b?a:b;
	}
}
